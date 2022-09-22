package com.arsenii.task3.subtask2;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache shapeCache = new ShapeCache();
        shapeCache.loadCache();
        System.out.println(shapeCache.getShape(1L).getType());
        System.out.println(shapeCache.getShape(2L).getType());
        System.out.println(shapeCache.getShape(3L).getType());
    }
}
