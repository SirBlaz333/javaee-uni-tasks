package com.arsenii.task5.subtask2;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        Circle circle = shapeMaker.drawCircle();
        Square square = shapeMaker.drawSquare();
        Triangle triangle = shapeMaker.drawTriangle();
        System.out.println(circle.draw());
        System.out.println(square.draw());
        System.out.println(triangle.draw());
    }
}
