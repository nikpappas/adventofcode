package com.adventofcode.aoc2017.day22;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Map;

public class CarrierSecond extends Carrier {

    public CarrierSecond() {
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
        String cur = map.getOrDefault(x + "," + y, ".");
        switch (cur) {
            case ".":
                actClean(map);
                break;
            case "#":
                actInfected(map);
                break;
            case "W":
                actWeakened(map);
                break;
            case "F":
                actFlagged(map);
                break;
        }
    }

    private void actFlagged(Map<String, String> map) {
        curMove = (curMove + 2) % moves.size();
        map.put(x + "," + y, ".");
        move();
        cleaned++;

    }

    private void actClean(Map<String, String> map) {
        turnLeft();
        map.put(x + "," + y, "W");
        move();
    }

    private void actWeakened(Map<String, String> map) {
        map.put(x + "," + y, "#");
        move();
        infected++;
    }

    private void actInfected(Map<String, String> map) {
        turnRight();
        map.put(x + "," + y, "F");
        move();
    }


}
