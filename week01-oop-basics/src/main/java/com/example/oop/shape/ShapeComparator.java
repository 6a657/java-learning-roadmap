package com.example.oop.shape;

import java.util.Comparator;

// 如何排序图形？

@FunctionalInterface
public interface ShapeComparator extends Comparator<Shape> {
    ShapeComparator BY_AREA = 
        (s1, s2) -> Double.compare(s1.area(), s2.area());

    ShapeComparator BY_PERIMETER = 
        (s1, s2) -> Double.compare(s1.perimeter(), s2.perimeter());
}