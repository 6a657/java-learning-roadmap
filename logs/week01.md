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

## 定长 VS 变长
- 定长数组：int[]，创建后无法改大小，工具为Arrays.toString和Arrays.sort
- 变长数组：ArrayList<Integer>，可以变长（add/remove），只能存对象，工具为Collections.reverse/max，stream

## final关键字
- 可以修饰类，方法和引用，被修饰的东西无法被新的实体覆盖或继承，但是被修饰的对象本身是可以修改的

## 重载(overload)VS重写(override)
- 前者是用不同的参数创建同一个类，比如注册用户，可以用电话号码或者邮箱进行注册，都会
产生用户
- 后者是用子类覆盖父类，比如猫本身的特征可以覆盖哺乳类动物的部分共性

## static变量
- 简单来说，它是全局变量，代表了一个类的某个特征