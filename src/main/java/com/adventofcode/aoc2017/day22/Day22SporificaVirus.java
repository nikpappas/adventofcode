package com.adventofcode.aoc2017.day22;

import com.adventofcode.aoc2017.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day22SporificaVirus {
    protected Carrier car;
    Map<String, String> map;

    public Day22SporificaVirus(String path, Carrier car) {
        map = Day22SporificaVirus.parseMap(path);
        this.car = car;
    }

    public void printMap() {
        int size = 25;
        for (int i = -size; i < size; i++) {
            for (int j = -size; j < size; j++) {
                String cur = map.getOrDefault(j + "," + i, ".");
                if (car.x == j && car.y == i) System.out.print("*");
                else System.out.print(cur);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Day22SporificaVirus app = new Day22SporificaVirus(INPUTS + "/day22.txt", new CarrierFirst());
        app.printMap();
        for (int i = 0; i < 10000; i++) {
            app.car.act(app.map);
//            app.printMap();
        }
        app.printMap();
        System.out.println("infected " + app.car.infected);
        System.out.println("cleaned " + app.car.cleaned);
        long hash = app.solve();
        System.out.println(hash);
    }

    long solve() {
        return map.values().stream().filter(x -> x.equals("#")).count();
    }

    private static Map<String, String> parseMap(String path) {
        Map<String, String> toRet = new HashMap<>();
        List<String> list = Utils.readFile(path).collect(Collectors.toList());

        int counter = -25 / 2;
        int hashCount = 0;
        for (String line : list) {
            String[] tokens = line.split("");
            int size = tokens.length;
            int limitX = -size / 2;
            for (int i = 0; i < size; i++) {
                if (tokens[i].equals("#")) hashCount++;
                toRet.put("" + limitX + "," + counter, tokens[i]);
                limitX++;
            }
            counter++;
        }
        System.out.println(hashCount);
        return toRet;
    }

}
