package com.soebes.katas.functional;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class F1
{

    Consumer<Integer> consumer;

//  public interface FunctionX<T, U> extends Function {
//    default <V> Function<V, U> compose(Function<V, T> f) {
//      return x -> apply(f.apply(x));
//    }
//  }

    @Test
    public void testName()
    {
        Function<Integer, Integer> triple = x -> x * 3;
        Function<Integer, Integer> square = x -> x * x;
        System.out.println( square.apply( triple.apply( 2 ) ) );
    }

    public interface BinaryOperator
        extends Function<Integer, Function<Integer, Integer>>
    {
    };

    @Test
    public void secondTest()
    {
        BinaryOperator add = x -> y -> x + y;
        BinaryOperator mult = x -> y -> x * y;
        System.out.println( "add:" + add.apply( 1 ).apply( 5 ) );
        System.out.println( "mult:" + mult.apply( 2 ).apply( 5 ) );
    }

    @Test
    public void thirdTest()
    {
        Function<Double, Double> f = x -> Math.PI / 2 - x;
        Function<Double, Double> sin = ( Double t ) -> Math.sin( t );
        Double cos = f.compose( sin ).apply( 2.0 );

        Function<Double, Double> squareRoot = x -> Math.sqrt( x );
        Function<Double, Double> square = x -> x * x;

        Function<Double, Double> andThen = squareRoot.compose( (Double t) -> square.apply( t ) );

        System.out.println( "andThen: " + andThen.apply( 15d ) );
        System.out.println( "cos:" + cos );
    }
}
