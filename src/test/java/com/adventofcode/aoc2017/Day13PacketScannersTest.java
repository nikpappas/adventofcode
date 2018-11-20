package com.adventofcode.aoc2017;


import org.junit.Before;
import org.junit.Test;

import static com.adventofcode.aoc2017.Utils.INPUTS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Day13PacketScannersTest {
    private Day13PacketScanners scanners;

    @Before
    public void setup(){
        scanners = new Day13PacketScanners(INPUTS + "/day13.txt");
    }

    @Test
    public void test13S1(){
        scanners.time = 6;
        assertTrue(scanners.isAhit(4));

    }
    @Test
    public void test13S2(){
        scanners.time = 5;
        assertFalse(scanners.isAhit(4));

    }
    @Test
    public void test13S3(){
        scanners.time = 7;
        assertFalse(scanners.isAhit(4));

    }
    @Test
    public void test13S4(){
        scanners.time = 12;
        assertTrue(scanners.isAhit(4));

    }
    @Test
    public void test13S5(){
        scanners.time = 11;
        assertFalse(scanners.isAhit(4));

    }
    @Test
    public void test13S6(){
        scanners.time = 13;
        assertFalse(scanners.isAhit(4));

    }
}