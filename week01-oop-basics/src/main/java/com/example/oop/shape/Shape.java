package com.example.oop.shape;

public interface Shape {
    double area();
    double perimeter();

    default String describe() {
        return String.format("%s: area=%.2f, perimeter=%.2f",
            getClass().getSimpleName(),
            area(),
            perimeter()
        );
    }
}