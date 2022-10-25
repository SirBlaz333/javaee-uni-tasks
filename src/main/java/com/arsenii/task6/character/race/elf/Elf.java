package com.arsenii.task6.character.race.elf;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.race.CharacterRace;

public class Elf extends CharacterRace {
    public Elf(String name, Stats bonuses){
        this.name = name;
        this.bonuses = bonuses;
    }

    @Override
    public void greetings() {
        System.out.println("Ola, que pasó?");
    }
}
