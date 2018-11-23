package com.soebes.katas.sublist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class PatternStreamTest
{

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
        Collectors.groupingBy( word -> word, Collectors.counting() );

    @Test
    void mapReduceExample()
    {
        Pattern pattern = Pattern.compile( "[, ':\\-\\.]+" );

        Map<String, Long> words =
            sonnet.stream()
            .map( String::toLowerCase )
            .flatMap( pattern::splitAsStream )
            .collect( Collectors.collectingAndThen( 
                                            GROUPING_BY, map -> Map.copyOf( map )
                                            )
               );

        Entry<String, Long> mostFrequentWord = words.entrySet().stream() // Stream<Map.Entry<String, Long>>
                                                    .max( Map.Entry.comparingByValue() ).orElseThrow();

        // Map<Long, String> result = words.entrySet().stream()
//                        .collect( 
//                                  Collectors.toMap( Map.Entry::getValue, Map.Entry::getKey ) 
//                                  );

        words.forEach( ( k, v ) -> System.out.println( " k=" + k + " v=" + v ) );
        System.out.println( "Frequent word:" + mostFrequentWord );
//        .forEach( word -> System.out.println( word ) );

    }
}
