package com.adventofcode.aoc2017;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day4HighEntropyPassphrasesTest {
    @Test
    public void test1(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee");

        assertEquals(1,app.solve());

    }
    @Test
    public void test2(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee aaa");
        assertEquals(1,app.solve());

    }
    @Test
    public void test3(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee aa");
        assertEquals(0,app.solve());

    }
    @Test
    public void test4(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa ba cc dd ee ab");
        assertEquals(0,app.solve());
    }

}