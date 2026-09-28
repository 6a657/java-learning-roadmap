package com.example.basics;

public class TypeDemo {
    public static void main(String[] args) {
        int i = 100;
        Integer iObj = i;
        int i2 = iObj;
        System.out.println("int="+i+", Integer="+iObj+", 拆箱后="+i2);

        Integer nullInt = null;
        try {
            int x = nullInt;
            System.out.println(x);
        } catch(NullPointerException e) {
            System.out.println("对null的Integer拆箱会抛NullPointerException");
        }

        // ===== Integer 缓存：-128 ~ 127 =====
        Integer a = 127, b = 127;
        Integer c = 128, d = 128;
        Integer e = -128, f = -128;
        Integer g = -129, h = -129;

        System.out.println("a==b (127,127): " + (a == b));   // true
        System.out.println("c==d (128,128): " + (c == d));   // false
        System.out.println("e==f (-128,-128): " + (e == f)); // true
        System.out.println("g==h (-129,-129): " + (g == h)); // false

        // 正确方法：使用equals或先转int
        System.out.println("c.equals(d): "+ c.equals(d));
        System.out.println("c.intValue()==d.intValue(): "+ (c.intValue()==d.intValue()));

        // ===== long / Long 缓存也一样（-128 ~ 127）=====
        Long p = 127L, q = 127L;
        Long r = 128L, s = 128L;
        System.out.println("Long 127==127: "+(q==p));
        System.out.println("Long 128==128: "+(r==s));

        // 浮点精度问题
        System.out.println("0.1+0.2 == 0.3 ? "+(0.1+0.2==0.3)); //False
        System.out.println("实际值: "+(0.1+0.2));

    }
}