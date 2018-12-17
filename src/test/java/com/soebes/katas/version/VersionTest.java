package com.soebes.katas.version;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class VersionTest
{

    @FunctionalInterface
    public interface VersionComparator<T>
    {
        int compare( T t1, T t2 );

        // PECS =>
        // producer: ? extends T
        // consumer: ? super T
        static <T, R extends Comparable<? super R>> VersionComparator<T> comparing( Function<? super T, R> extractor )
        {
            Objects.requireNonNull( extractor );
            return ( p1, p2 ) -> {
                R u1 = extractor.apply( p1 );
                R u2 = extractor.apply( p2 );
                return u1.compareTo( u2 );
            };
        }

        default <R extends Comparable<? super R>> VersionComparator<T> thenComparing( Function<? super T, R> extractor )
        {
            Objects.requireNonNull( extractor );
            return ( p1, p2 ) -> {
                int cmp = this.compare( p1, p2 );
                if ( cmp == 0 )
                {
                    VersionComparator<T> other = comparing( extractor );
                    return other.compare( p1, p2 );
                }
                else
                {
                    return cmp;
                }
            };
        }

        default VersionComparator<T> reversed()
        {
            return ( T t1, T t2 ) -> this.compare( t2, t1 );
        }

    }

    static final Pattern SPLIT_PATTERN = Pattern.compile( "[\\.]+" );

    @Test
    @Disabled
    void test1()
    {
        String versionLower = "1.2.6";
        String versionHigher = "1.3.1";

        List<String> collectVersionHigher = SPLIT_PATTERN.splitAsStream( versionHigher ).collect( Collectors.toList() );
        List<String> collectVersionLower = SPLIT_PATTERN.splitAsStream( versionLower ).collect( Collectors.toList() );

        collectVersionHigher.forEach( System.out::println );
        collectVersionLower.forEach( System.out::println );
 
        String V1 = "1.2.3-SNAPSHOT";
        System.out.println( "Result:" + V1.matches( ".*\\-SNAPSHOT" ));
    }
}