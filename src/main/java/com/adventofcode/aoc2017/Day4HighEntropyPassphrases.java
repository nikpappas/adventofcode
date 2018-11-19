package com.adventofcode.aoc2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4HighEntropyPassphrases {
    List<List<String>> passes;

    public Day4HighEntropyPassphrases(String s) {
        String[] passArr = s.split("\n");
        passes = Arrays.stream(passArr).map(x -> Arrays.asList(x.split(" "))).collect(Collectors.toList());
    }

    public Day4HighEntropyPassphrases(List<String> slist) {
        passes = slist.stream().map(x -> Arrays.asList(x.split(" "))).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list = Utils.readFile(Utils.INPUTS + "/passes.txt").collect(Collectors.toList());

        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases(list);
        System.out.println(app.solve());
    }

    int solve() {
        int sum = 0;
        System.out.println("passes size: " + passes.size());
        for (List<String> li : passes) {
            List<String> sortedWords = new ArrayList<>();
            for (String word : li) {
                String[] temp = word.split("");
                Arrays.sort(temp);
                sortedWords.add(String.join("", temp));
            }
//            boolean containsSameWords = li.size() != li.stream().distinct().collect(Collectors.toList()).size();
            boolean containsAnagrams = sortedWords.size() != sortedWords.stream().distinct().collect(Collectors.toList()).size();

            sum += containsAnagrams ? 0 : 1;
        }
        return sum;
    }
}
