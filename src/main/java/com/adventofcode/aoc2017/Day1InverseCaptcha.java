package com.adventofcode.aoc2017;

import java.math.BigInteger;

public class Day1InverseCaptcha {
    private BigInteger prob;

    public Day1InverseCaptcha(long prob) {
        this.prob = BigInteger.valueOf(prob);
    }

    public Day1InverseCaptcha(String prob) {
        this.prob = new BigInteger(prob);
    }

    public static void main(String args[]) {
        String contents = Utils.readFile(Utils.INPUTS + "/day1.txt")
                .findFirst().orElseThrow(RuntimeException::new);

        Day1InverseCaptcha app = new Day1InverseCaptcha(contents);

        System.out.println(app.solve());
        System.out.println(app.solveSecond());
    }

    public int solve() {
        String probS = prob.toString();
        int l = probS.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (probS.charAt(i) == probS.charAt((i + 1) % l)) {
                sum += Integer.parseInt("" + probS.charAt(i));
            }
        }
        return sum;
    }

    public int solveSecond() {
        String probS = prob.toString();
        int l = probS.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (probS.charAt(i) == probS.charAt((i + l / 2) % l)) {
                sum += Integer.parseInt("" + probS.charAt(i));
            }
        }
        return sum;
    }
}
