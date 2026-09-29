package com.example.basics;

public class PassByValueDemo {
    public static void main(String[] args) {
        // basic type: pass by value
        int num = 10;
        System.out.println("Raw num = "+num);
        modifyInt(num);
        System.out.println("Changed num = "+num); // 还是10

        // 对象引用，传递引用的副本(地址)
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("\nRaw sb = "+sb);
        modifyStringBuilder(sb);
        System.out.println("Changed sb = "+sb); // 变为Hello World

        // 给引用重新赋值，不影响外部
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println("\nRaw sb2 = "+sb2);
        reassignStringBuilder(sb2);
        System.out.println("Changed sb2 = "+sb2);

        // Array 也是如此
        int[] arr = {1,2,3};
        System.out.println("\nRaw arr[0] = "+arr[0]);
        modifyArray(arr);
        System.out.println("Change arr[0] = "+arr[0]);
    }

    // 修改int无效，因为传递的是副本
    public static void modifyInt(int x) {
        x = 999;
        System.out.println(" In function x = "+ x);
    }
    
    // 修改对象内容：有效，因为传递的地址指向的是同一个对象
    public static void modifyStringBuilder(StringBuilder sb){
        sb.append(" World");
        System.out.println(" In function sb = "+sb);
    }

    // 给引用赋值：无效，因为传递的地址的变量本身，和源地址没关系，修改了这个变量也没用
    public static void reassignStringBuilder(StringBuilder sb){
        sb = new StringBuilder("Changed");
        System.out.println(" In function sb = "+sb);
    }

    // 修改数组元素：有效
    public static void modifyArray(int[] arr) {
        arr[0] = 999;
        System.out.println(" In function arr[0] = "+arr[0]);
    }
}