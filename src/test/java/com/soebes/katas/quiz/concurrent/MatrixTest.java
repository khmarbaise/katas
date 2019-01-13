package com.soebes.katas.quiz.concurrent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.platform.commons.util.Preconditions;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MatrixTest {

    public static class Row<T> {

//        static <T> Row of(T... arguments) {
//            return () -> arguments;
//        }

//        static <T> Row arguments(T... arguments) {
//            return of(arguments);
//        }


    }

//    public interface Matrix<T> {
//        static Matrix row(T... t) {
//            //
//        }
//
//        boolean isEmpty();
//
//        static <T> Matrix<T> of (T t) {
//            return null;
//        }
//    }


    @Test
    void forkJoinTestNumber1() {
//        Matrix<Integer, Integer, Integer> matrix = Matrix.of(Row.of(1,2,3), columns.of(2,3,4), columns.of(5,6,7));

//        Stream<Row<Integer>> matrix = Stream.of(
//                Row.of(1L, 2L, 3L)
//        );

//        Matrix<Integer> m = Matrix
//                .row(1, 2, 3)
//                .row(4, 5, 6)
//                .row(7, 8, 9)
//                .build();
//
//
//        // 1. How to define a matrix of values
//        Matrix<Long> matrix = Matrix.of(
//                Row.of(1, 2, 3),
//                Row.of(4,5,6),
//                Row.of(7,8,9)
//        );
    }

    List<Integer> integers = List.of(1);

}
