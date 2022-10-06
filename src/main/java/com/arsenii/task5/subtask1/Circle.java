package com.arsenii.task5.subtask1;

public class Circle implements Shape {
    private final int x;
    private final int y;
    private final int radius;
    private final DrawAPI drawAPI;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawAPI = drawAPI;
    }

    @Override
    public String draw() {
        return drawAPI.drawCircle(x, y, radius);
    }
}
