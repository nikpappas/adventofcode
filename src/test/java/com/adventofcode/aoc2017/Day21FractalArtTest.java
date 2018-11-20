package com.adventofcode.aoc2017;

import org.junit.Before;
import org.junit.Test;

import static com.adventofcode.aoc2017.Utils.INPUTS;
import static org.junit.Assert.assertEquals;

public class Day21FractalArtTest {
    private Day21FractalArt test;

    @Before
    public void setup() {
        test = new Day21FractalArt(INPUTS + "/day21.txt");

    }

    @Test
    public void testFlipInvRot() {
        assertEquals(".#/.#", test.flipInvRot("../##", 1));
        assertEquals("##/..", test.flipInvRot(".#/.#", 1));

        assertEquals("#./..", test.flipInvRot(".#/..", 1));
        assertEquals("../#.", test.flipInvRot(".#/..", 2));

    }

    @Test
    public void testFlipHor() {
        assertEquals("../##", test.flipHor("../##"));
        assertEquals("#../#../#..", test.flipHor("..#/..#/..#"));
        assertEquals(".#./.#./.#.", test.flipHor(".#./.#./.#."));
    }

    @Test
    public void testFlipVer() {
        assertEquals("##/..", test.flipVer("../##"));
        assertEquals(".../.../###", test.flipVer("###/.../..."));
    }

    @Test
    public void testFlipRot() {
        assertEquals("#./#.", test.flipRot("../##", 1));
        assertEquals("../##", test.flipRot(".#/.#", 1));
        assertEquals("../.#", test.flipRot(".#/..", 1));
        assertEquals("../#.", test.flipRot(".#/..", 2));
        assertEquals(".../..#/...", test.flipRot(".#./.../...", 1));

    }


}