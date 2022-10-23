package com.arsenii.task6.character.type;

import java.util.ArrayList;
import java.util.List;

public class Paladin extends CharacterType {
    private final List<String> perks;

    public Paladin() {
        this.name = "Paladin";
        this.dice = 10;
        this.perks = new ArrayList<>();
        this.perks.add("Bless");
        this.perks.add("Aura of Life");
    }

    @Override
    public void printMagic() {
        System.out.println("Class: " + name + " can: ");
        for(String perk : perks){
            System.out.println("\n  " + perk);
        }
    }
}
