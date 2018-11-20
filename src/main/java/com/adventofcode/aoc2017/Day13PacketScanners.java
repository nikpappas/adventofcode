package com.adventofcode.aoc2017;


import java.util.*;
import java.util.stream.Collectors;

import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day13PacketScanners {
    Map<Integer, Integer> map;
    int time = 0;

    public Day13PacketScanners(String path) {
        map = parseConnections(path);
    }

    public static void main(String[] args) {
        Day13PacketScanners app = new Day13PacketScanners(INPUTS + "/day13.txt");
        System.out.println(app.map);
        app.solve();
        app.solve2();
    }
//35744

    private void solve2() {
        int offset = 0;
        Integer maxPosition = map.keySet().stream().max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        int position = 0;
        for (time = 0; position < maxPosition; time++) {
            position = time >= offset ? time - offset : -1;
            if (position != -1 && map.containsKey(position)) {
                if (isAhit(map.get(position))) {
                    offset++;
                    if (offset % 10000 == 0) System.out.println(offset);
                    time = offset - 1;
                    position = -1;
                }
            }
        }
        System.out.println(offset);
    }

    public void solve() {
        Optional<Integer> maxPosition = map.keySet().stream().max(Comparator.naturalOrder());
        List<Integer> list = new ArrayList<>();
        for (time = 0; time < maxPosition.get(); time++) {
            if (map.containsKey(time)) {
                if (isAhit(map.get(time))) {
                    list.add(map.get(time) * time);
                }
            }
        }
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        System.out.println(sum);
    }

    boolean isAhit(int range) {
        int scannerPosition = 0;
        int adjustedTime = time % (range * 2 - 2);
        boolean ascending = true;
        for (int i = 0; i < adjustedTime; i++) {
            if (scannerPosition == range - 1) ascending = false;
            if (scannerPosition == 0) ascending = true;
            if (ascending) {
                scannerPosition++;
            } else {
                scannerPosition--;
            }
        }
        return scannerPosition == 0;
    }

    private Map<Integer, Integer> parseConnections(String path) {
        return Utils.readFile(path).map(l -> l.split(": "))
                .collect(Collectors.toMap((String[] t) -> Integer.parseInt(t[0]), (String[] t) -> Integer.parseInt(t[1])));
    }

}