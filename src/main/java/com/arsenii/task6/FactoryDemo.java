package com.arsenii.task6;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task6.character.race.RaceFactory;
import com.arsenii.task6.character.race.elf.ElfFactory;
import com.arsenii.task6.character.type.CharacterTypeFactory;

public class FactoryDemo {
    public static void main(String[] args) {
        Character character = new Character("Valera",
                RaceFactory.create(new ElfFactory(), "Danmer Elf"),
                CharacterTypeFactory.getType("Rogue"));
        character.setStats(Stats.generate());
        character.addRaceBonuses();
        character.printSheet();
    }
}
