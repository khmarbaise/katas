package com.soebes.katas.sublist;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class SubListTest
{

    public static final Predicate<String> HASH_PREDICATE = "#"::equals; // s -> s.equals( "#" );

//    public static final Function<Integer, Boolean> XX = s -> s == 0;

    @Test
    void testName()
    {
        List<String> inputList = Arrays.asList( "a", "b", "#", "c", "#", "d", "e" );

        System.out.println( "inputList:" + inputList );
        System.out.println( "---------------------------------" );
        

        int[] edges = IntStream.range( -1, inputList.size() + 1 ) //
                               .filter( i -> i == -1 //
                                   || i == inputList.size() //
                                   || HASH_PREDICATE.test( inputList.get( i ) ) ) //
                               .toArray();

        List<List<String>> collect = IntStream.range( 0, edges.length - 1 ) //
                                              .mapToObj( k -> inputList.subList( edges[k] + 1, edges[k + 1] ) ) //
                                              .collect( Collectors.toList() );

        System.out.println( "Result:" + collect );
    }


}
