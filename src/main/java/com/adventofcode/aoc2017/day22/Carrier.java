package com.adventofcode.aoc2017.day22;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public abstract class Carrier {
    int x;
    int y;
    int curMove;
    List<Pair<Integer, Integer>> moves;
    int infected;
    int cleaned;

    public abstract void act(Map<String, String> map);

    public void move() {
        x += moves.get(curMove).getKey();
        y += moves.get(curMove).getValue();
    }

    public void turnLeft() {
        if (curMove == 0) curMove = moves.size() - 1;
        else curMove--;
    }
    public void turnRight() {
        curMove = (curMove + 1) % moves.size();
    }

}
