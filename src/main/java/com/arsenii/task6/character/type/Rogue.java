package com.arsenii.task6.character.type;

public class Rogue extends CharacterType {
    private final String perk;

    public Rogue() {
        this.name = "Rogue";
        this.dice = 8;
        this.perk = "Sneak Attack";
    }

    @Override
    public void printMagic() {
        System.out.println("Class: " + name + " can: " + perk);
    }
}
