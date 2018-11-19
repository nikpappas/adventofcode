package com.adventofcode.aoc2017;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day5MazeTwist {
    List<Integer> instr;

    public Day5MazeTwist() {
        instr = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        Day5MazeTwist app = new Day5MazeTwist();
        List<String> list = Utils.readFile(Utils.INPUTS + "/day5.txt").collect(Collectors.toList());
        list.forEach(s -> app.instr.add(Integer.parseInt(s)));

        int cursor = 0;
        int steps = 0;

        while (cursor < app.instr.size()) {
            int cur = app.instr.get(cursor);
//            Part Two Only
            if (cur >= 3) app.instr.set(cursor, cur - 1);
            else app.instr.set(cursor, cur + 1);
//            Part One Only
//            app.instr.set(cursor, cur+1);
            cursor += cur;
            steps++;
            System.out.println(steps + ", " + cursor + ", " + cur);
        }
        System.out.println(app.instr.get(0) + " " + app.instr.get(1) + " " + app.instr.get(2));

    }
}
