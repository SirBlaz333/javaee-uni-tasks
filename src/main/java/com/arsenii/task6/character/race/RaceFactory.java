package com.arsenii.task6.character.race;

public class RaceFactory {
    public static CharacterRace create(RaceAbstractFactory abstractFactory, String type){
        return abstractFactory.create(type);
    }
}
