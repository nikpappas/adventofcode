package com.adventofcode.aoc2017;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day1InverseCaptchaTest {

    @Test
    public void testDay1IC1() {
        Day1InverseCaptcha app = new Day1InverseCaptcha(1122);
        assertEquals(3, app.solve());
        assertEquals(0, app.solveSecond());
    }

    @Test
    public void testDay1IC2() {
        Day1InverseCaptcha app = new Day1InverseCaptcha(1111);
        assertEquals(4, app.solve());
        assertEquals(4, app.solveSecond());
    }

    @Test
    public void testDay1IC3() {
        Day1InverseCaptcha app = new Day1InverseCaptcha(1234);
        assertEquals(0, app.solve());
        assertEquals(0, app.solveSecond());
    }
    @Test
    public void testDay1IC4() {
        Day1InverseCaptcha app = new Day1InverseCaptcha(91212129);
        assertEquals(9, app.solve());
        assertEquals(6, app.solveSecond());
    }

}