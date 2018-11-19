package com.adventofcode.aoc2017;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day4HighEntropyPassphrasesTest {
    @Test
    public void test1(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee");
        System.out.println(app.solve());

    }
    @Test
    public void test2(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee aaa");
        System.out.println(app.solve());

    }
    @Test
    public void test3(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa bb cc dd ee aa");
        System.out.println(app.solve());

    }
    @Test
    public void test4(){
        Day4HighEntropyPassphrases app = new Day4HighEntropyPassphrases("aa ba cc dd ee ab");
        System.out.println(app.solve());

    }

}