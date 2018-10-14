package com.soebes.katas.streams;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamsTest {

	@Test
	public void testName() throws Exception {
		Path path = Paths.get(getClass().getResource("/test.txt").toURI());
		System.out.println("Path:" + path.toAbsolutePath());

		Files.lines(path).forEachOrdered(it -> System.out.println(it));
//		try (Stream<String> lines = Files.lines(path)) {
//			lines.forEachOrdered(it -> System.out.println(it));
			
//			Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
//			if (hasPassword.isPresent()) {
//				System.out.println(hasPassword.get());
//			}
//		}

	}

	public class T {

	}

	public class MappingStrategy<DynamicGenerateClass> {

	}

	@Test
	public void x() throws FileNotFoundException {
//		CsvToBean<T> reader = new CsvToBeanBuilder<T>(new FileReader("yourfile.csv")).withSeparator('\t').build();
		// reader.setMappingStrategy(Dy);

	}

	/*
	 * tabelle;ANTON columns;A;B;C format;int;int;int Dynamically generate a Class:
	 * public ClassANTON { public int getA() { ... public int getB() { public int
	 * getC() { ...
	 */

	//
	// @Test
	// public void f() throws IOException, URISyntaxException {
	//
	//
	// Stream<String> lines = Files.lines(Paths.get("c:/temp", "data.txt"));
	// Optional<String> hasPassword = lines.filter(s ->
	// s.contains("password")).findFirst();
	// if (hasPassword.isPresent()) {
	// System.out.println(hasPassword.get());
	// }
	// // Close the stream and it's underlying file as well
	// lines.close();
	// }
	//
	@Test
	public void testAnton() throws Exception {
		Path path = Paths.get(getClass().getResource("/test.txt").toURI());
		// The stream hence file will also be closed here
		try (Stream<String> lines = Files.lines(path)) {
//			lines.forEachOrdered(it -> System.out.println(it));
			
			Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
			if (hasPassword.isPresent()) {
				System.out.println(hasPassword.get());
			}
		}
	}
}
