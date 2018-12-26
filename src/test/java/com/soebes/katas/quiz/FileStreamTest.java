package com.soebes.katas.quiz;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

public class FileStreamTest {

    @Test
    void fileTest() throws URISyntaxException {

        Path path = Paths.get(getClass().getClassLoader()
                                        .getResource(".")
                                        .toURI());

        path.forEach(s -> System.out.println("File: " + s.toAbsolutePath()));

        FileSystem current = FileSystems.getDefault();
        current.getRootDirectories().forEach(s -> System.out.println("S:" + s));
        current.getFileStores().forEach(fs -> System.out.println("FS: " +fs.name() + " t:" + fs.type()));
//        Files.lines()
    }
}
