package com.arsenii.task6.character;

import com.arsenii.task4.subtask2.StatEnum;
import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.race.CharacterRace;
import com.arsenii.task6.character.type.CharacterType;

public class Character {
    private final String name;
    private final CharacterRace characterRace;
    private final CharacterType characterType;
    private Stats stats;
    private int health;

    public Character(String name, CharacterRace characterRace, CharacterType characterType) {
        this.name = name;
        this.characterRace = characterRace;
        this.characterType = characterType;
        health = 0;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void addRaceBonuses() {
        health = characterType.getDice() + (int) Math.floor(stats.getStatValue(StatEnum.CONSTITUTION) / 2.0) - 5;
    }

    public void printSheet() {
        System.out.println("Name: " + name);
        System.out.println(characterType.toString());
        System.out.println("Health: " + health);
        characterType.printMagic();
        characterRace.print();
        stats.printStats();
    }
}
