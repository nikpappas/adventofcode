package com.adventofcode.aoc2017.day22;

import static com.adventofcode.aoc2017.Utils.INPUTS;

public class Day22SporificaVirusPart2 extends Day22SporificaVirus {

    public Day22SporificaVirusPart2(String path, Carrier car) {
        super(path, car);
    }

    public static void main(String[] args) {
        Day22SporificaVirusPart2 app = new Day22SporificaVirusPart2(INPUTS + "/day22.txt", new CarrierSecond());
        app.printMap();
        for (int i = 0; i < 10000000; i++) {
            app.car.act(app.map);
//            app.printMap();
        }
        app.printMap();
        System.out.println("infected " + app.car.infected);
        System.out.println("cleaned " + app.car.cleaned);
        long hash = app.map.values().stream().filter(x -> x.equals("#")).count();
        System.out.println(hash);
    }

}
