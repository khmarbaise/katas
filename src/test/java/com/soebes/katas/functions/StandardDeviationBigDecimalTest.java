package com.soebes.katas.functions;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.stream.LongStream;

class StandardDeviationBigDecimalTest {

    public class BigDecimalSummaryStatistics
            implements Consumer<BigDecimal> {
        private Long count = Long.valueOf(0L);
        private BigDecimal sum = BigDecimal.ZERO;
        private BigDecimal min = null;
        private BigDecimal max = null;

        /**
         * Records a new {@code long} value into the summary information.
         *
         * @param value the input value
         */
        @Override
        public void accept(BigDecimal value) {
            count++;
            sum = sum.add(value);

            min = min == null ? value : min.min(value);
            max = max == null ? value : max.max(value);
        }

        public void combine(BigDecimalSummaryStatistics other) {
            count++;
            sum = sum.add(other.sum);

            min = min == null ? other.min : min.min(other.min);
            max = max == null ? other.max : max.max(other.max);
        }

        public final Long getCount() {
            return count;
        }

        public final BigDecimal getSum() {
            return sum;
        }

        public final BigDecimal getMin() {
            return min;
        }

        public final BigDecimal getMax() {
            return max;
        }

        public final BigDecimal getAverage() {
            if (getCount() > 0) {
                BigDecimal bsum = getSum();
                Long bcount = getCount();
                return bsum.divide(BigDecimal.valueOf(bcount));
            } else {
                return BigDecimal.ZERO;
            }
        }

        @Override
        public String toString() {
            return String.format(
                    "%s{count=%s, sum=%s, min=%s, average=%s, max=%s}",
                    this.getClass()
                        .getSimpleName(),
                    getCount().toString(),
                    getSum().toString(),
                    getMin().toString(),
                    getAverage().toString(),
                    getMax().toString()
            );
        }

    }

    @Test
    void standardDeviationBigDecimal() {
        BigDecimalSummaryStatistics collect =
                LongStream.rangeClosed(10, 2_000_001)
                          .mapToObj(BigDecimal::valueOf)
                          .collect(BigDecimalSummaryStatistics::new,
                                  BigDecimalSummaryStatistics::accept,
                                  BigDecimalSummaryStatistics::combine);

        System.out.println("Result BigDecimalSummaryStatistics:" + collect);

    }


}
