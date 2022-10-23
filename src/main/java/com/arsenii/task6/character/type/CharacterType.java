package com.arsenii.task6.character.type;

public abstract class CharacterType {
    protected String name;
    protected int dice;

    public abstract void printMagic();

    public int getDice() {
        return dice;
    }

    @Override
    public String toString() {
        return "Class: " + name + " uses " + dice + "Dice to roll hp bar";
    }
}
