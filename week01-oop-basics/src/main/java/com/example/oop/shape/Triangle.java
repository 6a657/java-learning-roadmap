package com.example.oop.shape;

public class Triangle extends AbstractShape {
    private final double a,b,c;
    public Triangle(double a, double b, double c) {
        super("Triangle");
        if (a<=0 || b<=0 || c<=0) {
            throw new IllegalArgumentException("sides must be larger than 0");
        }
        if (a+b<=c || a+c<=b || b+c<=a) {
            throw new IllegalArgumentException("invalid triangle sides");
        }
        this.a=a;this.b=b;this.c=c;
    }
    @Override public double area(){
        double s = perimeter() / 2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override public double perimeter(){
        return a+b+c;
    }
    @Override public String toString(){
        return String.format("Triangle[a=%.2f, b=%.2f, c=%.2f]",a,b,c);
    }
}