package com.soebes.codewars;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author khmarbaise
 *
 * {@link XYT}.
 * 
 */
public class MostFrequentlyUsedWordsInATextTest {
    public static final String GIVEN_TEXT = "In a village of La Mancha, " +
            "the name of which I have no desire to call to " +
            "mind, " +
            "there lived not long since one of those gentlemen " +
            "that keep a lance  in the lance-rack, " +
            "an old buckler, a lean hack, and a greyhound for coursing. " +
            "An olla of rather more beef than mutton, a salad on most " +
            "nights, scraps on Saturdays, lentils on Fridays, and a pigeon " +
            "or so extra on Sundays, made away with three-quarters of his income.";

    private static final Logger LOG = LoggerFactory.getLogger(MostFrequentlyUsedWordsInATextTest.class);

    public static class MostFrequentlyUsedWordsInAText {
        private final String text;

        private static final Pattern PATTERN = Pattern.compile("[, ':\\-.]+");

        public MostFrequentlyUsedWordsInAText(String text) {

            this.text = text;
        }

        /**
         * This code has been taken from {@link Map.Entry#comparingByValue()} and
         * made a reversed variant of it.
         *
         * @param <K> The key.
         * @param <V> The value.
         * @return {@link Comparator}
         */
        private static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValueReversed() {
            return (Comparator<Map.Entry<K, V>> & Serializable)
                    (c1, c2) -> c2.getValue().compareTo(c1.getValue());
        }

        public List<String> top3() {
            return PATTERN.splitAsStream(this.text)
                          .map(String::toLowerCase)
                          .filter(s -> !s.isEmpty())
                          .collect(groupingBy(word -> word, counting()))
                          .entrySet()
                          .stream()
                          .sorted(comparingByValueReversed())
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                          .limit(3)
                          .map(Map.Entry::getKey)
                          .collect(Collectors.toList());
        }

    }

    @Test
    void shouldReturnTheTop3Word() {
        MostFrequentlyUsedWordsInAText instance = new MostFrequentlyUsedWordsInAText(GIVEN_TEXT);
        assertThat(instance.top3()).isEqualTo(List.of("a", "of", "on"));
    }

    @Test
    void shouldReturnTheTop2Word() {
        MostFrequentlyUsedWordsInAText instance = new MostFrequentlyUsedWordsInAText("Word A");
        assertThat(instance.top3()).containsExactly("a", "word");
    }

    @Test
    void shouldReturnTheTop1Word() {
        MostFrequentlyUsedWordsInAText instance = new MostFrequentlyUsedWordsInAText("Word");
        assertThat(instance.top3()).containsExactly("word");
    }

    @Test
    void shouldReturnTheTop1WordWithATextWithOnlyASingleWord() {
        MostFrequentlyUsedWordsInAText instance = new MostFrequentlyUsedWordsInAText("Word Word Word");
        assertThat(instance.top3()).containsExactly("word");
    }
    
    @Test
    void shouldReturnEmptyListIfNoWordsGiven() {
        MostFrequentlyUsedWordsInAText instance = new MostFrequentlyUsedWordsInAText("");
        assertThat(instance.top3()).isEmpty();
    }
}
