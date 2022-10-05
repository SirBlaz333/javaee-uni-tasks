package com.arsenii.task4.subtask2;

public class DnDCharacter {
    private String name;
    private String className;
    private Stats stats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void printSheet(){
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        stats.printStats();
    }
}
