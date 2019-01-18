package com.soebes.katas.quiz;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FileStreamTest {

    @Test
    void fileTest() throws IOException {

        Path target = FileSystems.getDefault()
                                 .getPath("target", "test.log");

        Path path = Paths.get(getClass().getClassLoader()
                                        .getResource(".")
                                        .getPath(), "test.txt"
        );

        Stream<String> lines1 = Files.lines(path);
        Stream<String> lines2 = Files.lines(path);

        Stream<String> collect = Stream.of(lines1, lines2)
                                     .flatMap(i -> i);


        // This is equivalent to:
        // cat .. | sort | head -3
        Stream<String> limit = collect.map(s -> s.toUpperCase())
                                      .sorted()
                                      .limit(3);


        limit.forEachOrdered(s -> System.out.println("Zeile: " + s));

        collect.collect(toList());

//        FileSystem current = FileSystems.getDefault();
//        current.getRootDirectories().forEach(s -> System.out.println("S:" + s));
//        current.getFileStores().forEach(fs -> System.out.println("FS: " +fs.name() + " t:" + fs.type()));
//        Files.lines()
    }
}
