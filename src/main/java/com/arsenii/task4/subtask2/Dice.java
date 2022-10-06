package com.arsenii.task4.subtask2;

import java.util.Collections;
import java.util.Random;

public class Dice {
    private static final Integer ORIGIN = 0;
    private static final Integer BOUND = 6;
    private static final Integer ROLL_TIMES = 6;
    private static final Integer REQUIRED_DICE_COUNT = 3;
    private final Random random;

    public Dice() {
        random = new Random();
    }

    public int roll() {
        return random.nextInt(ORIGIN, BOUND);
    }

    public int rollStat() {
        return random.ints(ROLL_TIMES, ORIGIN, BOUND)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(REQUIRED_DICE_COUNT)
                .reduce(0, Integer::sum);
    }
}
