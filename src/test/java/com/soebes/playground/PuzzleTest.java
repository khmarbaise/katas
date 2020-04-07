package com.soebes.playground;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class PuzzleTest {

    @Test
    void get_number_of_processors() {
        System.out.println("true = " + Runtime.getRuntime().availableProcessors());
    }

    @Test
    void find_the_maximum_line_length_in_file() throws FileNotFoundException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader("CompileTest.java"));
        final int maximalLineLengthInFile = bufferedReader
                .lines()
                .mapToInt(String::length)
                .max()
                .getAsInt();

    }

    @Test
    void find_the_longest_line_in_file_variant_one() throws IOException, URISyntaxException {
        final URI resource = this
                .getClass()
                .getResource("/test.txt").toURI();
        final Stream<String> lines = Files.lines(Path.of(resource));

        final String max = lines
                .max(comparingInt(String::length))
                .get();
        System.out.println("max = " + max);
    }

    @Test
    void find_the_longest_line_in_file_variant_two() throws IOException, URISyntaxException {
        final URL resource = this
                .getClass()
                .getResource("/test.txt");
        final Stream<String> lines = Files.lines(Path.of(resource.toURI()));

        final String max = lines
                .reduce((acc, y) -> acc.length() > y.length() ? acc : y)
                .get();
        System.out.println("max = " + max);
    }

    @Test
    void another_test() {
        List<String> arrayList = List.of("A", "B");
        for (String item : arrayList) {
            if (item == null) {

            }
        }
    }
}
