package com.example.oop.shape;

public class Rectangle extends AbstractShape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width/height must be larger then 0");
        }
        this.width = width;
        this.height = height;
    }

    @Override public double area() {return width*height;}
    @Override public double perimeter() {return 2*(width+height);}

    public double getWidth() {return width;}
    public double getHeight() {return height;}

    @Override public String toString() {
        return String.format("Rectangle[w=%.2f, h=%.2f]", width, height);
    }
}