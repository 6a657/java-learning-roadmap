# Week 01 - Maven 入门

## 环境信息
- java: java 22 2024-03-19
- javac: javac 22
- mvn: Apache Maven 3.9.6

## Java 源码到运行的步骤
1. 编写 .java 源码
2. javac 编译为 .class 字节码
3. JVM 类加载器加载 .class
4. JVM 解释/JIT 执行字节码
5. 输出运行结果

## 概念
- .java：源代码，人类可读
- .class：字节码，平台无关，JVM 可执行
- JVM：Java 虚拟机，加载并运行字节码

## Maven 命令记录
- mvn clean test
- mvn package
- mvn exec:java

## 为什么 Integer a = 127, b = 127 时 == 是 true，128 时是 false？
- 自动装箱本质是调用 Integer.valueOf(i)
- 当值在 -128 ~ 127 之间，返回的是缓存里同一个对象，所以 a == b 比较的是同一个引用 → true
- == 比较的是引用地址（对包装类型）
- equals 比较的是值，所以包装类型应该用 equals。若要比较数值，也可先拆箱：a.intValue() == b.intValue()。

## 不同比较符号的区别：
- ==：比较的是引用地址，即是不是同一个对象，比较两个相同的苹果时，就会返回false。只有在比较同一个苹果时，才会返回true。
- equals：比较的是内容（值），比较两个相同的苹果时，会返回true，比较字符串会区分大小写
- equalsIgnoreCase：比较字符串会忽略大小写的区别