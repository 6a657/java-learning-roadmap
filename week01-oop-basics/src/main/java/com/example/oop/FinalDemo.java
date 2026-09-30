package com.example.oop;

// final类: 无法被继承，界门纲目科属种的种，没有下一级的孩子了
final class FinalClass {
    void hello() {}
}

// class SubFinalClass extends FinalClass {}   // 编译错误：cannot inherit from final

// final方法：无法被覆盖
class Parent {
    final void locked() {}
    void open() {}
}
class Child extends Parent {
    // @Override void locked() {} 
    //编译错误：locked() in Parent is final
    @Override void open() {} // 普通方法：可以被覆盖
}

// final引用字段：不可变地址，但是内容可变
class FinalRefDemo {
    private final StringBuilder sb = new StringBuilder("a");
    void mutate() {
        sb.append("b");
        // sb = new StringBuilder("c");  // 编译错误：cannot assign a value to final variable sb
    }
}

public class FinalDemo {
    public static void main(String[] args) {
        FinalRefDemo d = new FinalRefDemo();
        d.mutate();
        System.out.println("Final引用字符串地址没变，内容变了");
    }
}