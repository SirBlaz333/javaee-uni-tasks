package com.arsenii.task6.character.race.elf;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.race.Race;
import com.arsenii.task6.character.race.RaceAbstractFactory;

import java.util.HashMap;
import java.util.Map;

public class ElfFactory implements RaceAbstractFactory {
    private final Map<String, Stats> statsMap;

    public ElfFactory() {
        this.statsMap = new HashMap<>();
        this.statsMap.put("Danmer Elf", new Stats(0, 1, 0, 2, 0, 2));
        this.statsMap.put("Falmer Elf", new Stats(2, 2, 0, 0, 0, 0));
    }

    @Override
    public Race create(String type) {
        return new Elf(type, statsMap.get(type));
    }
}
