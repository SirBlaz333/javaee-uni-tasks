package com.arsenii.task5.subtask2.shape;

public class ShapeMaker {
    public Shape drawCircle(){
        return new Circle();
    }

    public Shape drawTriangle(){
        return new Triangle();
    }

    public Shape drawSquare(){
        return new Square();
    }
}
