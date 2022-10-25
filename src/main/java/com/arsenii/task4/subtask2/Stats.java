package com.arsenii.task4.subtask2;

import com.arsenii.task7.DataElement;
import com.arsenii.task7.DataElementVisitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Stats implements DataElement {
    private final Map<StatEnum, Integer> stats;
    private final Dice dice;

    public Stats() {
        stats = new HashMap<>();
        dice = new Dice();
        generateStats();
    }

    public Stats(int strength, int dexterity, int constitution, int intellect, int charisma, int wisdom){
        stats = new HashMap<>();
        dice = new Dice();
        stats.put(StatEnum.STRENGTH, strength);
        stats.put(StatEnum.DEXTERITY, dexterity);
        stats.put(StatEnum.CONSTITUTION, constitution);
        stats.put(StatEnum.INTELLECT, intellect);
        stats.put(StatEnum.CHARISMA, charisma);
        stats.put(StatEnum.WISDOM, wisdom);
    }

    public static Stats generate() {
        return new Stats();
    }

    private void generateStats() {
        Arrays.stream(StatEnum.values())
                .forEach(stat -> stats.put(stat, dice.rollStat()));
    }

    public int getStatValue(StatEnum statEnum){
        return stats.get(statEnum);
    }

    public void printStats() {
        System.out.println(this);
    }

    private String statToString(StatEnum statEnum) {
        return statEnum.toString().toLowerCase() + ": " + stats.get(statEnum);
    }

    @Override
    public String toString() {
        return Arrays.stream(StatEnum.values())
                .map(this::statToString)
                .map(s -> s.concat(System.lineSeparator()))
                .reduce(String::concat)
                .orElse(null);
    }

    @Override
    public TreeMap<String, String> access(DataElementVisitor visitor) {
        return visitor.visit(this);
    }
}
