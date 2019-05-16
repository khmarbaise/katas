package com.soebes.experiments;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;

class MapExpermimentsTest {

    @Test
    void firstTest() {
        Map<String, Integer> mapOfDatae = Map.ofEntries(
                entry("first", Integer.valueOf(1)),
                entry("second", Integer.valueOf(2))
        );

        if (!mapOfDatae.containsKey("first")) {
            throw new IllegalArgumentException("Failed to find.");
        }
        Integer element = mapOfDatae.get("firest");

    }
}
