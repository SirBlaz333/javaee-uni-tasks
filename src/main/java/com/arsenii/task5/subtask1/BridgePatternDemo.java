package com.arsenii.task5.subtask1;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(1, 1, 3, new GreenCircle());
        System.out.println(circle.draw());
        circle = new Circle(3, 3, 15, new RedCircle());
        System.out.println(circle.draw());
    }
}
