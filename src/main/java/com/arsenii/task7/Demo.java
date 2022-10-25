package com.arsenii.task7;

import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task6.character.race.RaceFactory;
import com.arsenii.task6.character.race.elf.ElfFactory;
import com.arsenii.task6.character.type.CharacterTypeFactory;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        ElementVisitor elementVisitor = new ElementVisitor();
        Character character = new Character("Valera",
                RaceFactory.create(new ElfFactory(), "Danmer Elf"),
                CharacterTypeFactory.getType("Rogue"));
        character.setStats(Stats.generate());

        List<DataElement> dataElements = new ArrayList<>();
        dataElements.add(character);
        dataElements.add(character.getCharacterType());
        dataElements.add(character.getCharacterRace());
        dataElements.add(character.getStats());

        JSONObject jsonObject = new JSONObject();
        dataElements.stream()
                .map(dataElement -> dataElement.access(elementVisitor))
                .forEach(jsonObject::putAll);

        Character character2 = new Character("Son of Valera",
                RaceFactory.create(new ElfFactory(), "Danmer Elf"),
                CharacterTypeFactory.getType("Paladin"));
        character2.setStats(Stats.generate());

        dataElements.clear();
        dataElements.add(character2);
        dataElements.add(character2.getCharacterType());
        dataElements.add(character2.getCharacterRace());
        dataElements.add(character2.getStats());

        JSONObject jsonObject2 = new JSONObject();
        dataElements.stream()
                .map(dataElement -> dataElement.access(elementVisitor))
                .forEach(jsonObject2::putAll);

        try (FileWriter fileWriter = new FileWriter("output.json")) {
            fileWriter.write("[");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.write(",");
            fileWriter.write(jsonObject2.toJSONString());
            fileWriter.write("]");
        }
    }
}
