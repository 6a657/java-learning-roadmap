package com.example.basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlFlowDemo {
    public static void main(String[] args) {
        // FizzBuzz
        System.out.println("=== FizzBuzz (1~20) ===");
        fizzBuzz(20);

        // 9*9
        System.out.println("\n=== 9*9 table ===");
        multiplicationTable();

        // judge run year
        System.out.println("\n=== judge leap year ===");
        int[] years = {1900, 2000, 2023, 2024, 2100};
        for (int y: years) System.out.println("is "+y+" leap year? "+isLeapYear(y));

        // read year from control table
        System.out.println("\n=== input year to judge leap year (input q to quit) ===");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("plz input year: ");
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("quit.");
                break;
            }

            try {
                int year = Integer.parseInt(line);
                if (year < 1) {
                    System.out.println("hint: year must be larger than 0");
                    continue;
                }
                System.out.println(year+" "+(isLeapYear(year)?"Yes":"No")+"leap year");
            } catch (NumberFormatException e) {
                System.out.println("hint: \""+line+"\" isn't legal year, plz input integer(such 2024).");
            }
        }
        scanner.close();
    }

    // FizzBuzz: Fizz is 3* and Buzz is 5*. FizzBuzz is 15*.
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 9*9 table
    public static void multiplicationTable() {
        for (int i = 1; i <= 9; i++){
            for (int j = i; j <= 9; j++){
                System.out.printf("%d*%d=%-2d ", j, i, i*j);
            }
            System.out.println();
        }
    }

    // judge leap year
    public static boolean isLeapYear(int year) {
        return (year%4==0 && year%100!=0) || (year%400==0);
    }
}