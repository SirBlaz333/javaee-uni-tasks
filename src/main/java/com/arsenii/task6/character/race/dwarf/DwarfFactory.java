package com.arsenii.task6.character.race.dwarf;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.race.Race;
import com.arsenii.task6.character.race.RaceAbstractFactory;

import java.util.HashMap;
import java.util.Map;

public class DwarfFactory implements RaceAbstractFactory {
    private final Map<String, Stats> statsMap;

    public DwarfFactory() {
        statsMap = new HashMap<>();
        statsMap.put("Hill Dwarf", new Stats(0, 0, 2, 0, 1, 0));
        statsMap.put("Mountain Dwarf", new Stats(2, 0, 2, 0, 0, 0));
    }

    @Override
    public Race create(String type) {
        return new Dwarf(type, statsMap.get(type));
    }
}
