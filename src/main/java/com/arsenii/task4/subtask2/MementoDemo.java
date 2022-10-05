package com.arsenii.task4.subtask2;

public class MementoDemo {
    public static void main(String[] args) {
        DnDCharacter character = new DnDCharacter();

        Stats stats = Stats.generate();
        character.setStats(stats);
        character.setName("Ivan");
        character.setClassName("Ork");
        character.printSheet();

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        stats = Stats.generate();
        stats.printStats();
        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        stats = Stats.generate();
        stats.printStats();
        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        stats = originator.getStateFromMemento(careTaker.get(0));
        stats.printStats();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        stats = originator.getStateFromMemento(careTaker.get(1));
        stats.printStats();
    }
}
