package com.arsenii.task3.subtask2;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
    private final Map<Long, Shape> shapeMap;

    public ShapeCache() {
        shapeMap = new HashMap<>();
    }

    public Shape getShape(Long id) {
        try{
            Shape shape = shapeMap.get(id);
            return (Shape) shape.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
    }

    public void loadCache() {
        Circle circle = new Circle();
        circle.setId(1L);
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(2L);
        shapeMap.put(rectangle.getId(), rectangle);

        Square square = new Square();
        square.setId(3L);
        shapeMap.put(square.getId(), square);
    }
}
