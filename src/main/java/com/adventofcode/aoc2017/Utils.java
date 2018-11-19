package com.adventofcode.aoc2017;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {
    public static final String INPUTS = "inputs";

    public static final Stream<String> readFile(String pathString){
        try {
            return Files.lines(Paths.get(pathString));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }
}
