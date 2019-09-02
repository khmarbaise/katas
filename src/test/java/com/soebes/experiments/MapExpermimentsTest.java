package com.soebes.experiments;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

class MapExpermimentsTest {

    @Test
    void firstTest() {
        Map<String, Integer> mapOfData = Map.ofEntries(
                entry("first", Integer.valueOf(1)),
                entry("second", Integer.valueOf(2))
        );

        if (!mapOfData.containsKey("first")) {
            throw new IllegalArgumentException("Failed to find.");
        }
        Integer element = mapOfData.get("firest");

    }

    @Test
    void firstCheck() {

        Map<String, String> mapping = new HashMap<>();

        mapping.put("K1", "V1");
        mapping.put("K2", "V2");
        assertThat(mapping.containsKey(null)).isFalse();

    }

}
