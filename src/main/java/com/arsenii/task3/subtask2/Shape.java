package com.arsenii.task3.subtask2;

public abstract class Shape implements Cloneable {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public abstract String getType();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
