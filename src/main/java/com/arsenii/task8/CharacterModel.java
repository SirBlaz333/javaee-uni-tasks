package com.arsenii.task8;

import com.arsenii.task4.subtask2.CareTaker;
import com.arsenii.task4.subtask2.Memento;
import com.arsenii.task4.subtask2.Stats;
import com.arsenii.task6.character.Character;
import com.arsenii.task6.character.race.RaceAbstractFactory;
import com.arsenii.task6.character.race.RaceFactory;
import com.arsenii.task6.character.race.dwarf.DwarfFactory;
import com.arsenii.task6.character.race.elf.ElfFactory;
import com.arsenii.task6.character.type.CharacterTypeFactory;
import com.arsenii.task7.DataElementVisitor;
import com.arsenii.task7.ElementVisitor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CharacterModel {
    private static CharacterModel characterModel;
    private final DataElementVisitor dataElementVisitor;
    private final List<Character> characters;
    private CareTaker careTaker;
    private Character character;
    private Stats stats;

    private CharacterModel() {
        dataElementVisitor = new ElementVisitor();
        characters = new ArrayList<>();
    }

    public static CharacterModel getInstance() {
        if (characterModel == null) {
            characterModel = new CharacterModel();
        }
        return characterModel;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void saveStats(Memento memento){
        careTaker = new CareTaker();
        careTaker.add(memento);
    }

    public Stats getLastSavedStats(){
        return careTaker.get(0).getState();
    }

    public Character createCharacter(String name, String race, String clazz){
        RaceAbstractFactory raceAbstractFactory = new ElfFactory();
        if(race.contains("Dwarf")){
            raceAbstractFactory = new DwarfFactory();
        }
        return new Character(name,
                RaceFactory.create(raceAbstractFactory, race),
                CharacterTypeFactory.getType(clazz));
    }

    public List<Character> getCharacters(){
        return characters;
    }

    public void addCharacterToList(Character character) {
        characters.add(character);
    }

    public DataElementVisitor getDataElementVisitor() {
        return dataElementVisitor;
    }
}
