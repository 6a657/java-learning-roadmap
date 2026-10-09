package com.example.oop.shape;

public abstract class AbstractShape implements Shape {
    private final String name;

    protected AbstractShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}