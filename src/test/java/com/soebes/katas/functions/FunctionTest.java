package com.soebes.katas.functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class FunctionTest
{

    @Test
    public void testForInitializers()
    {
        Function<Integer, Integer> tripple = x -> x * 3;

        System.out.println( tripple.apply( 10 ) );
    }

    @Test
    public void testXXX()
    {
        Function<Integer, Function<Integer, Integer>> tripple = x -> y -> x + y;

        System.out.println( tripple.apply( 10 ).apply( 5 ) );
    }

    @Test
    public void testFunctionsWithMap()
    {
        List<String> collect = Stream.of( "A", "B", "C", "D", "E" )
            .filter( m -> 
                (
                   m.contains( "A" ) || m.contains( "B" ) 
                ) 
            )
            .map( FunctionTest::mapFunction)
            .collect( Collectors.toList() );
        
        assertThat( collect ).hasSize( 2 );
        assertThat( collect ).containsExactly( "Prefix: A", "Prefix: B" );
    }

    static String mapFunction( String in )
    {
        return "Prefix: " + in;
    }

    @Test(expectedExceptions = { UnsupportedOperationException.class })
    public void xxxTestStream() {
//        List<String> asList = Collections.unmodifiableList( Arrays.asList( "a", "b", "c" ));
        List<String> asList = Arrays.asList( "a", "b", "c" );
        asList.add( "X" );
        asList.remove( 0 );
    }
    
    @Test(enabled = false)
    public void shouldBeXXX()
    {
        // cos a = sin (pi/2-a)
//        Function<Double, Double> umfang = x -> x * 2 * Math.PI;
        Function<Double, Double> umfang = radius -> 2.0 * Math.PI * radius;
//        assertThat( umfang.apply( 2.0 ) ).isEqualTo( 12.1444 );
        //Double cos = Function.compose( (Double x) -> Math.PI / 2.0 - x, Math::sin).apply(2.0);
    }
}
