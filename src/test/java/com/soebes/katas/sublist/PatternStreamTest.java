package com.soebes.katas.sublist;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class PatternStreamTest {

    //@formatter:off
    private List<String> sonnet = List.of(
            "From fairest creatures we desire increase,",
            "That thereby beauty's rose might never die,",
            "But as the riper should by time decease,",
            "His tender heir might bear his memory:",
            "But thou contracted to thine own bright eyes,",
            "Feed'st thy light's flame with self-substantial fuel,",
            "Making a famine where abundance lies,",
            "Thy self thy foe, to thy sweet self too cruel:",
            "Thou that art now the world's fresh ornament,",
            "And only herald to the gaudy spring,",
            "Within thine own bud buriest thy content,",
            "And, tender churl, mak'st waste in niggarding:",
            "Pity the world, or else this glutton be,",
            "To eat the world's due, by the grave and thee.");
    //@formatter:on

    private static final Collector<String, ?, Map<String, Long>> GROUPING_BY =
            groupingBy(
                  word -> word, 
                  counting()
              );

    private static final Pattern PATTERN = Pattern.compile("[, ':\\-\\.]+");

    private static final Function<String, Stream<String>> SPLIT_TO_WORDS = (String s) -> {
        System.out.println( "SPLIT_TO_STREAM:" + s );
        return PATTERN.splitAsStream( s );
    };

    private static final Function<String, String> TO_UPPERCASE = (s) -> {
        System.out.println( "TO_UPPERCASE:" + s );
        return s.toUpperCase();
    };
    
    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValueReverted() {
        return (Comparator<Map.Entry<K, V>> & Serializable)
            (c1, c2) -> c2.getValue().compareTo(c1.getValue());
    }

    
    @Test
    void mapReduceExample() {

        Map<String, Long> words =
                sonnet.stream()
                      .map(TO_UPPERCASE)
                      .flatMap(SPLIT_TO_WORDS)
                      .collect(
                         collectingAndThen(
                             GROUPING_BY, Map::copyOf
                         )
                      );

        Entry<String, Long> mostFrequentWord = words //
                    .entrySet() //
                    .stream() // Stream<Map.Entry<String, Long>>
//                    .sorted( Map.Entry.comparingByValue() )
                    .max(Map.Entry.comparingByValue()) //
                    .orElseThrow();

        // Map<Long, String> result = words.entrySet().stream()
//                        .collect( 
//                                  Collectors.toMap( Map.Entry::getValue, Map.Entry::getKey ) 
//                                  );

//        words.forEach((k, v) -> System.out.println(" k=" + k + " v=" + v));
//        System.out.println("Most frequent word:" + mostFrequentWord);
//        .forEach( word -> System.out.println( word ) );

    
        Comparator<Entry<String, Long>> compare = Comparator.comparing( Map.Entry::getValue );
        
        // cat Maps | sort -r | head -5 
        Stream<Entry<String, Long>> top5 = words //
                        .entrySet() //
                        .stream() //
                        .sorted( compare.reversed() ) //
                        .limit( 5 );

//        top5.forEach( e -> {
//            System.out.println( "Entry:" + e.getKey() + " v:" + e.getValue());
//        });


        Map<String, Long> counter = new HashMap<>();
    }
}
