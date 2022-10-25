package com.arsenii.task6.character.type;

import com.arsenii.task7.DataElement;
import com.arsenii.task7.DataElementVisitor;

import java.util.TreeMap;

public abstract class CharacterType implements DataElement {
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

    @Override
    public TreeMap<String, String> access(DataElementVisitor visitor) {
        return visitor.visit(this);
    }
}
