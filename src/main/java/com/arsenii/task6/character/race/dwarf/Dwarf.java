package com.arsenii.task6.character.race.dwarf;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.race.Race;

public class Dwarf extends Race {
    public Dwarf(String name, Stats bonuses){
        this.name = name;
        this.bonuses = bonuses;
    }
    @Override
    public void greetings() {
        System.out.println("Kavaboonga!");
    }
}
