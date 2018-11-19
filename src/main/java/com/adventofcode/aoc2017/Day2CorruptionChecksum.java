package com.adventofcode.aoc2017;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2CorruptionChecksum {
    private List<List<Integer>> spreadsheet;
    private Function<List<String>, List<Integer>> convertToIntegerListLambda = x -> x.stream().map(Integer::parseInt).collect(Collectors.toList());

    public Day2CorruptionChecksum(List<String> spreadsheet) {

        this.spreadsheet = parseSpreadSheet(spreadsheet);
    }

    public static void main(String[] args) throws Exception {
        List<String> contents = Utils.readFile(Utils.INPUTS + "/day2.txt").collect(Collectors.toList());
        Day2CorruptionChecksum app = new Day2CorruptionChecksum(contents);
        System.out.println(app.checkSum());
        System.out.println(app.checkSumDiv());
    }

    private List<List<Integer>> parseSpreadSheet(List<String> spreadsheet) {
        List<List<Integer>> parsedSpreadsheet = spreadsheet.stream()
                .map((String x) -> Arrays.asList(x.split("\t")))
                .map(convertToIntegerListLambda)
                .collect(Collectors.toList());

        return parsedSpreadsheet;
    }

    private int checkSum() {
        int sum = 0;
        for (List<Integer> list : spreadsheet) {
            sum += rowCheck(list);
        }
        return sum;
    }

    private int checkSumDiv() throws Exception {
        int sum = 0;
        for (List<Integer> list : spreadsheet) {
            sum += rowCheckDivision(list);
        }
        return sum;
    }

    private int rowCheck(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : list) {
            if (max <= i) max = i;
            if (min >= i) min = i;
        }
        return max - min;
    }

    private int rowCheckDivision(List<Integer> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                int cursor = list.get(j);
                if (cur >= cursor) {
                    if (cur % cursor == 0) return cur / cursor;
                }
                if (cursor % cur == 0) return cursor / cur;
            }
        }
        throw new Exception("Divisors not found");
    }
}
