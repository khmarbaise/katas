package com.soebes.katas.sublist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

class PlayWithConsumerTest
{

    @Test
    void testName()
    {
        Consumer<List<String>> consumer = List::clear;

        List<String> list = new ArrayList<>( Arrays.asList( "a", "b", "c" ) );

        consumer.accept( list );
        assertThat( list ).isEmpty();
    }

    @FunctionalInterface
    public interface XConsumer<T>
    {
        void accept( T t );

        default XConsumer<T> andThen( XConsumer<T> other )
        {
            Objects.requireNonNull( other );
            return (T t) -> {
                this.accept( t );
                other.accept( t );
            };
        }
    }

    @Test
    void consumeAdding()
    {
        XConsumer<List<String>> consumer1 = t -> t.add( "first" );
        XConsumer<List<String>> consumer2 = t -> t.add( "second" );

        XConsumer<List<String>> cons = consumer1.andThen( consumer2 );

        List<String> list = new ArrayList<>( Arrays.asList( "a", "b", "c" ) );
        cons.accept( list );

        assertThat( list ).containsExactly( "a", "b", "c", "first", "second" );
        
    }
}
