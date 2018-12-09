package com.soebes.katas.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;

public class StandardDeviationTest
{

    @FunctionalInterface
    public interface BigIntegerConsumer
    {
        /**
         * Performs this operation on the given argument.
         *
         * @param value the input argument
         */
        void accept( BigInteger value );

    }

    public class BigIntegerSummaryStatistics
        implements BigIntegerConsumer
    {
        private BigInteger count = BigInteger.ZERO;
        private BigInteger sum = BigInteger.ZERO;
        private BigInteger min = null;
        private BigInteger max = null;

        /**
         * Records a new {@code long} value into the summary information.
         *
         * @param value the input value
         */
        @Override
        public void accept( BigInteger value )
        {
            count = count.add( BigInteger.ONE );
            sum = sum.add( value );

            min = min == null ? value : min.min( value);
            max = max == null ? value : max.max( value );
        }

        public void combine(BigIntegerSummaryStatistics other) {
            count = count.add( other.count );
            sum = sum.add( other.sum );

            min = min == null ? other.min : min.min( other.min );
            max = max == null ? other.max : max.max( other.max );
        }

        public final BigInteger getCount() {
            return count;
        }
        public final BigInteger getSum() {
            return sum;
        }
        public final BigInteger getMin() {
            return min;
        }
        
        public final BigInteger getMax() {
            return max;
        }
        
        public final BigDecimal getAverage() {
            
            if (getCount().compareTo( BigInteger.ZERO ) > 0) {
                BigDecimal bsum = new BigDecimal( getSum());
                BigDecimal bcount = new BigDecimal (getCount());
                return bsum.divide( bcount);
            } else {
                return BigDecimal.ZERO;
            }
        }
        
        @Override
        public String toString() {
            return String.format(
                "%s{count=%s, sum=%s, min=%s, average=%s, max=%s}",
                this.getClass().getSimpleName(),
                getCount().toString(),
                getSum().toString(),
                getMin().toString(),
                getAverage().toString(),
                getMax().toString());
        }
        
    }

    @Test
    void standardDeviation()
    {
	LongSummaryStatistics collect = LongStream
		.rangeClosed(10, 10_000_000) //
		.collect(LongSummaryStatistics::new, //
			LongSummaryStatistics::accept, // 
			LongSummaryStatistics::combine);
        System.out.println( "Result:" + collect );

    }
    
    @Test
    void standardDeviationBigInteger()
    {
        BigIntegerSummaryStatistics collect =
            LongStream.rangeClosed( 1, 1_000 )
            .mapToObj( m -> BigInteger.valueOf(m) )
            .collect( BigIntegerSummaryStatistics::new, 
                      BigIntegerSummaryStatistics::accept, 
                      BigIntegerSummaryStatistics::combine );
        
        System.out.println( "Result BigIntegerSummaryStatistics:" + collect );

//      Long reduce = LongStream
//      .rangeClosed( 1, 100 )
//      .mapToObj( Long::valueOf )
//      .reduce( Long.valueOf( 0 ),  );
        
    }
    

}