package com.adventofcode.aoc2017.day22;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class CarrierFirst extends Carrier {

    public CarrierFirst() {
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

}
