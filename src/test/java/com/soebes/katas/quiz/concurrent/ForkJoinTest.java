package com.soebes.katas.quiz.concurrent;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ForkJoinTest {

    @Test
    void forkJoinTestNumber1() {
//        Matrix<Integer, Integer, Integer> matrix = Matrix.of(Row.of(1,2,3), columns.of(2,3,4), columns.of(5,6,7));

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

    public interface Matrix<T> {
//        static Matrix row(T... t) {
//            //
//        }

        boolean isEmpty();

        static <T> Matrix<T> of (T t) {
            return null;
        }
    }

    public static class Row<T> {
        static <T> T of (T t) {
            return null;
        }

    }
}
