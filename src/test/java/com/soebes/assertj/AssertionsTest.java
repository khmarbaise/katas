package com.soebes.assertj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

class AssertionsTest {

    private List<String> givenList = List.of("A", "B", "C", "D", "C");

    private Map<String, String> givenMap = Map.ofEntries(
            entry("K1", "V1"),
            entry("K2", "V2"),
            entry("K3", "V3")
    );

    private Set<String> givenSet = Set.of("AB", "CD");

    @Nested
    @DisplayName("hasSize works for")
    class HasSize {

        @Test
        void checkSizeOfListInTheWrongWay() {
            int size = givenList.size();
            assertThat(size).isEqualTo(6);
        }

        @Test
        @DisplayName("givenList")
        void checkListHavingSizeEqualTo() {
            assertThat(givenList).hasSize(6);
        }

        @Test
        @DisplayName("givenMap")
        void checkMapHavingSizeEqualTo() {
            assertThat(givenMap).hasSize(5);
        }

        @Test
        @DisplayName("givenSet")
        void checkSetHavingSizeEqualTo() {
            assertThat(givenSet).hasSize(5);
        }

    }

    @Nested
    @DisplayName("Prüfe inhalte von Listen")
    class ContainsTest {

        @Test
        void checkForContentInListOfSingleElemtny() {
            assertThat(givenList).contains("X");
        }

        @Test
        void shouldContainTwoElementsInGivenList() {
            assertThat(givenList).contains("C", "X");
        }

        @Test
        void containsExactlyTwoElements() {
            assertThat(givenList).containsExactly("C", "X");
        }

        @Test
        void containsSequence() {
            assertThat(givenList).containsSequence("B", "D");
        }

        @Test
        void containsWithIndex() {
            assertThat(givenList).contains("C", atIndex(3));
        }
    }


    @Nested
    @DisplayName("Superfluous null checks")
    class NullCheckTest {

        @Test
        void firstVariant() {
            List<String> actual = null;
            assertThat(actual).isNotNull();
            assertThat(actual).hasSize(5);
        }

        @Test
        void secondVariant() {
            List<String> actual = null;
            assertThat(actual).isNotNull().hasSize(5);
        }

        @Test
        void thisIsTheWayToGo() {
            List<String> actual = null;
            assertThat(actual).hasSize(5);
        }
    }


    @Nested
    class DoNotGoThatWay {
        @Test
        @DisplayName("How to define Constants https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html")
        void pseudoConstant() {
            final int EXP = 22;
            assertThat(givenList).hasSize(EXP);
        }
    }

    @Nested
    class ThisIsTheRightWay {
        private static final int EXPECTED_NUMBER_OF_ELEMENTS = 6;

        @Test
        void thisIsTestWhichIsUsingAConstant() {
            assertThat(givenList).hasSize(EXPECTED_NUMBER_OF_ELEMENTS);
        }
    }
}
