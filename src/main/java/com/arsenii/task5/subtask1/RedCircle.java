package com.arsenii.task5.subtask1;

public class RedCircle implements DrawAPI {
    @Override
    public String drawCircle(int x, int y, int radius) {
        return String.format("Draw red circle in point(%d, %d) with radius %d;", x, y, radius);
    }
}
