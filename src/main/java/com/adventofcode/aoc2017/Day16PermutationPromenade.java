package com.adventofcode.aoc2017;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day16PermutationPromenade {
    ArrayDeque<Character> p;
    List<String> inst;

    public Day16PermutationPromenade() {
        p = makeProgramList('p');
    }

    public static void main(String[] args) {
        Day16PermutationPromenade app = new Day16PermutationPromenade();
        app.inst = app.parseInstructions(INPUTS + "/day16.txt");
        System.out.println(app.inst);
        System.out.println(app.inst.size());
        System.out.println("starting with " + app.p);
        try {
            int total = 1;
            while (total < 1000000000) {
                app.solve();
                if (app.compareWithInitial()) {
                    break;
                }
                total++;
            }
            System.out.println(total);
            System.out.println(app.p);
            int loop = 1;
            while (loop <= (1000000000 % total)) {
                app.solve();
                System.out.println(loop + " " + app.p);
                loop++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(app.p);

    }

    private boolean compareWithInitial() {
        Iterator it = p.iterator();
        for (char c = 'a'; it.hasNext(); c++) {
            if (!it.next().equals(c)) return false;
        }
        return true;
    }

    private void solve() throws Exception {
        for (String i : inst) {
            char operation = i.charAt(0);
            switch (operation) {
                case 's':
                    spin(Integer.parseInt(i.substring(1)));
                    break;
                case 'x':
                    swapByPos(i.substring(1));
                    break;
                case 'p':
                    swapByName(i.substring(1));
                    break;
                default:
                    throw new Exception("should never hang around here");
            }

        }
    }

    private void swapByPos(String substring) {
        String[] positions = substring.split("/");
        int pos1 = Integer.parseInt(positions[0]);
        int pos2 = Integer.parseInt(positions[1]);
        Character[] array = p.toArray(new Character[0]);
        Character swapChar = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = swapChar;
        p = new ArrayDeque<>(Arrays.asList(array));

    }

    private void swapByName(String substring) {
        String[] names = substring.split("/");
        String name1 = names[0];
        String name2 = names[1];
        int index1 = -1;
        int index2 = -1;
        int index = 0;
        Iterator<Character> it = p.iterator();
        while (index1 == -1 || index2 == -1 && it.hasNext()) {
            Character nex = it.next();
            if (nex == name1.charAt(0)) index1 = index;
            if (nex == name2.charAt(0)) index2 = index;
            index++;
        }
        swapByPos(index1 + "/" + index2);

    }

    private void spin(int i) {
        int count = 0;
        while (count < i) {
            p.addFirst(p.removeLast());
            count++;
        }
    }

    private ArrayDeque<Character> makeProgramList(char limit) {
        ArrayDeque<Character> list = new ArrayDeque<>();
        for (char c = 'a'; c <= limit; c++) {
            list.addLast(c);
        }
        return list;
    }

    private List<String> parseInstructions(String path) {
        return Utils.readFile(path)
                .flatMap(l -> Arrays.stream(l.split(",")))
                .collect(Collectors.toList());
    }

}
