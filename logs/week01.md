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

## 重载(overload) VS 重写(override)
- 前者是用不同的参数创建同一个类，比如注册用户，可以用电话号码或者邮箱进行注册，都会
产生用户
- 后者是用子类覆盖父类，比如猫本身的特征可以覆盖哺乳类动物的部分共性

## static变量
- 简单来说，它是全局变量，代表了一个类的某个整体特征

## 接口：interface
- 它代表了一种能力，基于这些能力派生出来的类，都有这些能力。派生使用implements关键字。
这些类可以完全不同，比如鸟和虫。他们都有飞行能力。

## 抽象类：abstract class
- 它代表了一种原始类，是所有同一类东西所共用的特征类。比如把世界所有人抽象出来，类似于假人
一样的形象。继承使用extends关键字。一般来说，它的很多方法只是空在那里，
如果要实现的话，需要在子类进一步实现。一般来说，子类都拥有父类的能力，也能共享
状态和模板逻辑，必须要在复用状态的情况下，采用抽象类。

## 多态
- 只依赖于不同子类的共一个父类来对某种东西进行操作。而这些东西，需要对这些接口
有继承/实现关系，且子类重写了父类/接口的方法。

## equals和hashCode
- 在Java中，如果a.equals(b)为true，那么二者的.hashCode()必须相同；反之可能相同。
如果把两个对象放在HashSet/HashMap，会先在hashCode找桶，在桶中用equals逐个比较。
但是如果不重写hashcode而只重写equals，那么即使是内容相同的对象，放在map中，因为
二者的hashcode不同，就把他们放在不同的桶中，所以就把它们同时存在集合中，无法去重。