package com.arsenii.task4.subtask2;

public class Memento {
    private final Stats state;

    public Memento(Stats state) {
        this.state = state;
    }

    public Stats getState() {
        return state;
    }
}
