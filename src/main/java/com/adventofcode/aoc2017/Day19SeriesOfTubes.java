package com.adventofcode.aoc2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.adventofcode.aoc2017.Day19SeriesOfTubes.Dir.*;
import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day19SeriesOfTubes {

    private int steps;

    enum Dir {
        DOWN,
        UP,
        RIGHT,
        LEFT
    }

    private Dir direction;
    private final List<List<String>> map;
    private int x;
    private int y;
    private List<String> result;

    public Day19SeriesOfTubes(String path) {
        map = Day19SeriesOfTubes.parseMap(path);
        x = 0;
        y = 0;
        direction = DOWN;
        result = new LinkedList<>();
        steps = 0;
    }

    public static void main(String[] args) {
        Day19SeriesOfTubes app = new Day19SeriesOfTubes(INPUTS + "/day19.txt");
        app.solve();
    }

    public void solve() {
        getInitialPosition();
        boolean couldGo = true;
        while (couldGo) {
            if (Character.isAlphabetic(map.get(y).get(x).charAt(0))) {
                result.add(map.get(y).get(x));
            }
            switch (direction) {
                case DOWN:
                    couldGo = goDown();
                    break;
                case UP:
                    couldGo = goUp();
                    break;
                case LEFT:
                    couldGo = goLeft();
                    break;
                case RIGHT:
                    couldGo = goRight();
                    break;
                default:
                    break;
            }
            steps++;
            System.out.println(x + ", " + y);
        }
        System.out.println(result);
        System.out.println(steps);
    }


    private boolean choseDirection() {
        Dir curDirect = direction;
        if (direction.equals(DOWN) || direction.equals(UP)) {
            if (canGoLeft()) direction = LEFT;
            if (canGoRight()) direction = RIGHT;
        } else {
            if (canGoUp()) direction = UP;
            if (canGoDown()) direction = DOWN;
        }
        System.out.println(map.get(y - 1).get(x - 1) + map.get(y - 1).get(x) + map.get(y - 1).get(x + 1));
        System.out.println(map.get(y).get(x - 1) + map.get(y).get(x) + map.get(y).get(x + 1));
        System.out.println(map.get(y + 1).get(x - 1) + map.get(y + 1).get(x) + map.get(y + 1).get(x + 1));
        System.out.println(curDirect + " " + direction);
        if (curDirect.equals(direction)) return false;
        return true;
    }

    private boolean goDown() {
        direction = DOWN;
        boolean canGo = canGoDown();
        if (canGo) {
            y++;
            if (map.get(y).get(x).equals("+")) choseDirection();
            return true;
        }
        return false;
    }

    private boolean goUp() {
        direction = UP;
        boolean canGo = canGoUp();
        if (canGo) {
            y--;
            if (map.get(y).get(x).equals("+")) choseDirection();
            return true;
        }
        return false;
    }

    private boolean goLeft() {
        direction = LEFT;
        boolean canGo = canGoLeft();
        if (canGo) {
            x--;
            if (map.get(y).get(x).equals("+")) choseDirection();

            return true;
        }
        return false;
    }

    private boolean goRight() {
        direction = RIGHT;
        boolean canGo = canGoRight();
        if (canGo) {
            x++;
            if (map.get(y).get(x).equals("+")) choseDirection();
            return true;
        }
        return false;
    }

    private boolean canGoDown() {
        return canGoToCell(x, y + 1);
    }

    private boolean canGoUp() {
        return canGoToCell(x, y - 1);
    }

    private boolean canGoLeft() {
        return canGoToCell(x - 1, y);
    }

    private boolean canGoRight() {
        return canGoToCell(x + 1, y);
    }

    private boolean canGoToCell(int x, int y) {
        if (y < 0 || y > map.size()) return false;
        if (x < 0 || x > map.get(y).size()) return false;
        String ch = map.get(y).get(x);
        if (ch.equals(" ")) {
            return false;
        }
        return true;
    }

    private void getInitialPosition() {
        boolean found = false;
        while (!found) {
            String cur = map.get(y).get(x);
            if (!cur.equals("|")) x++;
            if (cur.equals("|")) found = true;

        }
    }

    private static List<List<String>> parseMap(String path) {
        return Utils.readFile(path).map(l -> {
            String[] lineToks = l.split("");
            return Arrays.asList(lineToks);
        }).collect(Collectors.toList());
    }

}
