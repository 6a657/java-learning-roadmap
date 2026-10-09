package com.example.oop.shape;

import java.util.Objects;

public class Circle extends AbstractShape {
    private final double radius;
    private final String color;

    public Circle(double radius, String color) {
        super("Circle");
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be larger than 0");
        }
        this.radius = radius;
        this.color = Objects.requireNonNull(color, "color");
    }

    @Override public double area() {return Math.PI*radius*radius;}
    @Override public double perimeter() {return 2*Math.PI*radius;}

    public double getRadius() {return radius;}
    public String getColor() {return color;}

    @Override 
    public String toString() {
        return String.format("Circle[r=%.2f, color=%s]", radius, color);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
            Objects.equals(color, circle.color);
    }

    @Override public int hashCode() {
        return Objects.hash(radius, color);
    }
}