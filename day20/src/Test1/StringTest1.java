package Test1;/*
    @description
    @author Serenity
    @create 2022-01-15-21:41
    String的实例化方式

    方式一：通过字面量定义的方式
    方式二：通过new + 构造器的方式
    面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
          两个：一个是堆空间中new的结构，另一个是char[]对应的常量池中的数据：”abc“


*/

import org.junit.Test;

public class StringTest1 {
    @Test
    public void test1(){
        //通过字面量定义的方式:此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false

        System.out.println("********************");
        Person p1 = new Person("Tom" ,12);
        Person p2 = new Person("Tom" ,12);
        System.out.println(p1.name.equals(p2.name)); //true
        System.out.println(p1.name == p2.name); // true
        p1.name = "Jerry";
        System.out.println(p2.name);
        System.out.println(p1.name.equals(p2.name)); // false
    }

//    常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
//
//    只要其中有一个是变量，结果就在堆中
//
//    如果拼接的结果调用intern（）方法，返回值就在常量池中
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop"; //两个字面量联结，直接从常量池找连接后的地址
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s5 == s6); //false
        System.out.println(s5 == s7); //false
        System.out.println(s6 == s7); //false

        String s8 = s5.intern();//返回值得到的s8使用的常量池中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8); //true
    }
    @Test
    public void Test4(){
        String s3 = "javaEEhadoop";  //在方法区的常量池中
        String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        System.out.println(s3 == s5); //false

        final String s6 = "javaEE";  //s6是常量
        String s7 = s6 + "hadoop";
        System.out.println(s3 == s7); //true
    }
}
