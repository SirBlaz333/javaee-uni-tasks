package com.arsenii.task4.subtask2;

import java.util.Random;

public class Dice {
    private static final Integer ORIGIN = 0;
    private static final Integer BOUND = 6;
    private static final Integer ROLL_TIMES = 3;
    private final Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(ORIGIN, BOUND);
    }

    public int rollStat() {
        int sum = 0;
        for (int i = 0; i < ROLL_TIMES; i++) {
            sum += roll();
        }
        return sum;
    }
}
