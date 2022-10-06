package com.arsenii.task5.subtask2;

import com.arsenii.task5.subtask2.shape.Shape;
import com.arsenii.task5.subtask2.shape.ShapeMaker;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        Shape circle = shapeMaker.drawCircle();
        Shape square = shapeMaker.drawSquare();
        Shape triangle = shapeMaker.drawTriangle();
        System.out.println(circle.draw());
        System.out.println(square.draw());
        System.out.println(triangle.draw());
    }
}
