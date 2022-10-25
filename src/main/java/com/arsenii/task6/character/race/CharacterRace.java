package com.arsenii.task6.character.race;

import com.arsenii.task4.subtask2.StatEnum;
import com.arsenii.task4.subtask2.Stats;

import java.util.Arrays;

public abstract class CharacterRace {
    protected String name;
    protected Stats bonuses;

    public Stats getBonuses() {
        return bonuses;
    }

    public abstract void greetings();

    public String toString() {
        return name;
    }

    public void print() {
        System.out.println("Race: " + name);
        Arrays.stream(StatEnum.values())
                .filter(statEnum -> bonuses.getStatValue(statEnum) != 0)
                .forEach(this::printRaceStat);
    }

    public void printRaceStat(StatEnum statEnum) {
        System.out.println("Race bonus: " + statEnum.toString().toLowerCase() + " -> " + bonuses.getStatValue(statEnum));
    }
}
