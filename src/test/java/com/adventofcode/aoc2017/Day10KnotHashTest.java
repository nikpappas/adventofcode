package com.adventofcode.aoc2017;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day10KnotHashTest {
    @Test
    public void testGetHash(){
        int dense= 0;
        List<Integer> inputs = Arrays.asList(65 ,27 , 9 , 1 ,4 , 3,  40 , 50 , 91 , 7 , 6 , 0 , 2 , 5 , 68 , 22 );
        int sum=0;
        for(int j=0;j<16;j++){
            sum ^= inputs.get(j);
        }
        assertEquals(64,sum);
    }

}