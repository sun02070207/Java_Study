package Test1;/*
    @description
    @author Serenity
    @create 2022-01-15-21:12

    String的使用

*/

import org.junit.Test;

public class StringTest {
    /*
    String:字符串，使用一对""引起来表示。
    1.String声明为final的，不可被继承。
    2.String实现了Serializable接口：表示字符串是支持序列化的。
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于存储字符串数据
    4.String:代表不可变的字符序列。简称：不可变性
        体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
             2.当对现有的字符串进行连接操作“+”时，也需要重新指定内存区域赋值，不能使用原有value进行赋值
             3.当调用String的replace()方法修改指定的字符或字符串，也需要重新指定内存区域赋值，不能使用原有value进行赋值

    5.通过字面量的方式(区别于new)给一个字符串赋值，此时的字符串值声明在字符串常量池中
    6.字符串常量池中是不会存储相同内容的字符串的

    */
    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";

        System.out.println(s1 == s2);//比较的s1与s2的地址值，当s1和s2都是abc时，返回true

        System.out.println(s1); //hello
        System.out.println(s2); //abc

        System.out.println("****************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        System.out.println("**************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'c');
        System.out.println(s4);//abc
        System.out.println(s5);//cbc
    }
}
