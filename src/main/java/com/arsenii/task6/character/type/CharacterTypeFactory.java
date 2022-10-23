package com.arsenii.task6.character.type;

public class CharacterTypeFactory {
    public static CharacterType getType(String type){
        if(type.equals("Paladin")){
            return new Paladin();
        }
        if(type.equals("Rogue")){
            return new Rogue();
        }
        return null;
    }
}
