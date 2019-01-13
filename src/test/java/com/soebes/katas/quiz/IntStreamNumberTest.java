package com.soebes.katas.quiz;

import org.junit.jupiter.api.Test;

import java.io.ObjectStreamConstants;
import java.math.BigInteger;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.function.LongSupplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntStreamNumberTest {
    @Test
    void rangeClosed() {
        long count = IntStream.rangeClosed(1, 100)
                              .filter(i -> i % 2 != 0)
                              .peek(s -> System.out.println("range: " + s))
                              .boxed()
                              .count();
        System.out.println("Number of generated numbers: " + count);

        BigInteger b = BigInteger.valueOf(2L);


    }

    @Test
    void iterateWithTwoParameters() {
        long count1 = IntStream.iterate(1, i -> i + 2)
                               .limit(50)
                               .peek(s -> System.out.println("r:" + s))
                               .boxed()
                               .count();

        System.out.println("Number of generated numbers: " + count1);

    }

    @Test
    void iterateWithThreeParameters() {
        long count = IntStream.iterate(1, i -> i <= 100, i -> i + 2)
                              .boxed()
                              .count();
        System.out.println("Number of generated numbers:" + count);
    }

    static final BigInteger TWO = BigInteger.valueOf( 2 );

    static final BigInteger FOUR = BigInteger.valueOf( 4 );

    @Test
    void name() {
        int p = 9689;

        BigInteger m_p = BigInteger.ONE.shiftLeft( p ).subtract( BigInteger.ONE );

        BigInteger s = FOUR;
        for ( int i = 3; i <= p; i++ )
        {
            s = s.multiply( s ).subtract( TWO ).mod( m_p );
        }


//        IntStream.iterate(3, i -> i<= p, i -> i+1).collect(Collectors.reducing(FOUR, k -> k.multiply(k).subtract(TWO).mod(m_p)));
        System.out.println("M_P: "+ m_p + " s=" + s);
    }


    @Test
    void anotherTest() {
        int p = 9689;
        BigInteger m_p = BigInteger.ONE.shiftLeft( p ).subtract( BigInteger.ONE );
        System.out.println("m_p:" + m_p);
        BigInteger reduce = IntStream.iterate(3, i -> i <= p, i -> i + 1)
                                               .mapToObj(BigInteger::valueOf)
                                               .reduce(FOUR, (s1, s2) -> s1.multiply(s1).subtract(TWO).mod(m_p));
        System.out.println(" s=" + reduce);
    }
}
