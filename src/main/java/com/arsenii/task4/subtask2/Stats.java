package com.arsenii.task4.subtask2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stats {
    private final Map<StatEnum, Integer> stats;
    private final Dice dice;

    public Stats() {
        stats = new HashMap<>();
        dice = new Dice();
        generateStats();
    }

    public static Stats generate() {
        return new Stats();
    }

    private void generateStats() {
        Arrays.stream(StatEnum.values())
                .forEach(stat -> stats.put(stat, dice.rollStat()));
    }

    public void printStats() {
        Arrays.stream(StatEnum.values()).forEach(this::printStat);
    }

    private void printStat(StatEnum statEnum) {
        System.out.println(statEnum.toString().toLowerCase() + ": " + stats.get(statEnum));
    }
}
