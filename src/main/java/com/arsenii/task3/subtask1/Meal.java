package com.arsenii.task3.subtask1;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private final List<Item> items;

    public Meal() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        return items.stream()
                .reduce(0f, (price, item) -> price + item.getPrice(), Float::sum);
    }

    public void showItems() {
        items.forEach(this::printItem);
    }

    private void printItem(Item item) {
        System.out.println("Item: " + item.getName());
        System.out.println(", Packing: " + item.getPacking());
        System.out.println(", Price: " + item.getPrice());
    }
}
