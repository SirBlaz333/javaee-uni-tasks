package com.arsenii.task3.subtask1;

public class VeganBurger extends Burger {
    @Override
    public String getName() {
        return "Vegan burger";
    }

    @Override
    public Float getPrice() {
        return 4.5f;
    }
}
