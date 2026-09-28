package com.example.basics;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = "HELLO";

        System.out.println("s1 == s2: "+(s1==s2));
        System.out.println("s1 == s3: "+(s1==s3));
        System.out.println("s1.equals(s3): "+s1.equals(s3));
        System.out.println("s1.equals(s4): "+s1.equals(s4));

        // 统计数字，字母，空格
        String text = "Hello world 2026, Java 99!";
        int digits = 0, letters = 0, spaces = 0, others = 0;
        for (char ch: text.toCharArray()){
            if (Character.isDigit(ch)){
                digits++;
            } else if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                others++;
            }
        }
        System.out.println("字符串: \"" + text + "\"");
        System.out.println("数字个数: " + digits);
        System.out.println("字母个数: " + letters);
        System.out.println("空格个数: " + spaces);
        System.out.println("其他字符: " + others);
    }
}