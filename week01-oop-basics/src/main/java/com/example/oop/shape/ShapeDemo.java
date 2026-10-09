package com.example.oop.shape;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShapeDemo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2, "red"));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Triangle(3, 4, 5));
        shapes.add(new Circle(1, "blue"));

        // 多态
        ShapeService service = new ShapeService();
        service.printSummary(shapes);

        // 排序
        System.out.println("\n---- sort by area ----");
        List<Shape> byArea = new ArrayList<>(shapes);
        byArea.sort(ShapeComparator.BY_AREA);
        byArea.forEach(s -> System.out.printf("%-30s area=%.2f%n", s, s.area()));

        System.out.println("\n---- sort by perimeter ----");
        List<Shape> byPeri = new ArrayList<>(shapes);
        byPeri.sort(ShapeComparator.BY_PERIMETER);
        byPeri.forEach((s -> System.out.printf("%-30s perimeter=%.2f%n", s, s.perimeter())));

        // equals / hashcode 实验
        equalsHashCodeExperiment();
    }

    private static void equalsHashCodeExperiment() {
        System.out.println("\n---- equals/hashcode experiment ----");
        Circle c1 = new Circle(2, "red");
        Circle c2 = new Circle(2, "red");
        Circle c3 = new Circle(3, "red");

        System.out.println("c1.equals(c2) = "+c1.equals(c2));
        System.out.println("c1.hashCode() = "+c1.hashCode());
        System.out.println("c2.hashCode() = "+c2.hashCode());

        Set<Circle> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);
        System.out.println("HashSet size = "+set.size());

        // only rewrite equals but not rewrite hashcode
        System.out.println("\n---- BadCircle only rewrite equals ----");
        Set<BadCircle> badSet = new HashSet<>();
        badSet.add(new BadCircle(2, "red"));
        badSet.add(new BadCircle(2, "red"));
        System.out.println("BadCircle HashSet size = "+badSet.size());
    }

    static class BadCircle {
        final double radius;
        final String color;
        BadCircle(double r, String c) {
            this.radius = r;
            this.color = c;
        }
        @Override 
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof BadCircle)) return false;
            BadCircle b = (BadCircle) o;
            return Double.compare(b.radius, radius) == 0 && color.equals(b.color);
        }
    }
}