package com.arsenii.task7;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task6.character.race.CharacterRace;
import com.arsenii.task6.character.type.CharacterType;

import java.util.TreeMap;

public class ElementVisitor implements DataElementVisitor {
    @Override
    public TreeMap<String, String> visit(Character character) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Name", character.getName());
        treeMap.put("HP", Integer.toString(character.getHealth()));
        return treeMap;
    }

    @Override
    public TreeMap<String, String> visit(CharacterType characterType) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Class", characterType.toString());
        return treeMap;
    }

    @Override
    public TreeMap<String, String> visit(CharacterRace characterRace) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Race", characterRace.toString());
        return treeMap;
    }

    @Override
    public TreeMap<String, String> visit(Stats stats) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Stats", stats.toString());
        return treeMap;
    }
}
