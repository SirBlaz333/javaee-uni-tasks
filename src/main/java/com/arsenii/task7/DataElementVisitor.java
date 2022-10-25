package com.arsenii.task7;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task6.character.race.CharacterRace;
import com.arsenii.task6.character.type.CharacterType;

import java.util.TreeMap;

public interface DataElementVisitor {
    TreeMap<String, String> visit(Character character);

    TreeMap<String, String> visit(CharacterType characterType);

    TreeMap<String, String> visit(CharacterRace characterRace);

    TreeMap<String, String> visit(Stats stats);
}
