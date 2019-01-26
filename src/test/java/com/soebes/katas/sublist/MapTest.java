package com.soebes.katas.sublist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class MapTest {
	// Do a version comparator
	// based on the example of Person comparator
	// in Java 8 ?

	@Test
	void testName() {
		Map<String, List<String>> mapList = new HashMap<>();

		mapList.computeIfAbsent("FirstMapKey", m -> new ArrayList<>()).add("EntryOne");

		// if (!mapList.containsKey("First")) {
		//   List<String> subList = new ArrayList<>();
		//   subList.add("Second");
		//   mapList.put("First", subList);
		// }

		mapList.computeIfPresent("FirstMapKey", (k, v) -> v).add("EntrySecond");

		mapList.compute("FirstMapKey", (k, v) -> v == null ? new ArrayList<>() : v).add("EntryThird");
		mapList.compute("SecondMapKey", (k, v) -> v == null ? new ArrayList<>() : v).add("SecondMapKey-EntryOne");

		// mapList.putIfAbsent("SecondMapKey", new ArrayList<>()).add("EntrySecondOne");

		// FIXME: Not yet correctly understood ?
		mapList.merge("ThirdsMapKey", new ArrayList<>(), (k, v) -> v).add("EntryThirdMapKey-One");
		mapList.merge("ThirdsMapKey", new ArrayList<>(), (k, v) -> v).add("EntryThirdMapKey-Two");
		mapList.entrySet().forEach(entry -> System.out.println("K:" + entry.getKey() + " V:" + entry.getValue()));

//		mapList.computeIfAbsent("XX", throw new IllegalArgumentException("test"));

	}
}
