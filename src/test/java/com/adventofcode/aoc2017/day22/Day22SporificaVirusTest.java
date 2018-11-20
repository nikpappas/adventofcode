package com.adventofcode.aoc2017.day22;

import org.junit.Test;

import java.util.HashMap;

import static com.adventofcode.aoc2017.Utils.INPUTS;
import static org.junit.Assert.assertEquals;

public class Day22SporificaVirusTest {

    @Test
    public void test() {
        Day22SporificaVirus sporifica = new Day22SporificaVirus(INPUTS + "/day22.txt", new CarrierSecond());
        sporifica.map = new HashMap<>();
        sporifica.map.put("-1,-1", ".");
        sporifica.map.put("0,-1", ".");
        sporifica.map.put("1,-1", "#");
        sporifica.map.put("-1,0", "#");
        sporifica.map.put("0,0", ".");
        sporifica.map.put("1,0", ".");
        sporifica.map.put("-1,1", ".");
        sporifica.map.put("0,1", ".");
        sporifica.map.put("1,1", ".");

        assertEquals(2L,sporifica.solve());

    }
}