package com.adventofcode.aoc2017;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day22SporificaVirus {
    private Carrier car;
    private Map<String, String> map;

    public Day22SporificaVirus(String path) {
        map = Day22SporificaVirus.parseMap(path);
        //τεστ Μαπ
//        map = new HashMap<>();
//        map.put("-1,-1",".");
//        map.put("0,-1",".");
//        map.put("1,-1","#");
//        map.put("-1,0","#");
//        map.put("0,0",".");
//        map.put("1,0",".");
//        map.put("-1,1",".");
//        map.put("0,1",".");
//        map.put("1,1",".");
        car = new Carrier();
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
        Day22SporificaVirus app = new Day22SporificaVirus(INPUTS + "/day22.txt");
        app.printMap();
        for (int i = 0; i < 10000; i++) {
            app.car.act(app.map);
//            app.printMap();
        }
        app.printMap();
        System.out.println("infected " + app.car.infected);
        System.out.println("cleaned " + app.car.cleaned);
        long hash = app.map.values().stream().filter(x -> x.equals("#")).count();
        System.out.println(hash);
    }

    class Carrier {
        int x;
        int y;
        int curMove;
        List<Pair<Integer, Integer>> moves;
        int infected;
        int cleaned;

        public Carrier() {
            moves = new ArrayList<>();
            moves.add(new Pair<>(0, -1));
            moves.add(new Pair<>(1, 0));
            moves.add(new Pair<>(0, 1));
            moves.add(new Pair<>(-1, 0));
            curMove = 0;
            x = 0;
            y = 0;
            infected = 0;
            cleaned = 0;
        }

        public void act(Map<String, String> map) {
            if (map.getOrDefault(x + "," + y, ".").equals("#")) actInfected(map);
            else actClean(map);

        }

        private void actClean(Map<String, String> map) {
            turnLeft();
            map.put(x + "," + y, "#");
            move();
            infected++;
        }

        private void actInfected(Map<String, String> map) {
            turnRight();
            map.put(x + "," + y, ".");
            move();
            cleaned++;
        }

        public void turnLeft() {
            if (curMove == 0) curMove = moves.size() - 1;
            else curMove--;
        }

        public void turnRight() {
            curMove = (curMove + 1) % moves.size();
        }

        public void move() {
            x += moves.get(curMove).getKey();
            y += moves.get(curMove).getValue();
        }
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
