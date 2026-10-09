package com.example.oop.shape;

import java.util.List;

public class ShapeService {
    public void printSummary(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            System.out.println("There's no shape");
            return;
        }
        double totalArea = 0;
        double totalPerimeter = 0;

        System.out.println("--- Shape Summary ---");
        for (Shape s: shapes){
            double a = s.area();
            double b = s.perimeter();
            totalArea += a;
            totalPerimeter += b;
            System.out.printf("%-30s area=%8.2f  perimeter=%8.2f%n",s.toString(),a,b);
        }
        System.out.println("-----------------------------------");
        System.out.printf("Total area     == %.2f%n", totalArea);
        System.out.printf("Total perimeter    == %.2f%n", totalPerimeter);
    }
}