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