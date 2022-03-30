package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-17:05

    关于StringBuffer和StringBuilder的使用

*/

import org.junit.Test;

public class StringBufferBuilderTest {
    /*
    String、StringBuffer、StringBuilder三者的异同？
    String:不可变的字符序列：底层使用char[]存储
    StringBuffer:可变的字符序列：线程安全，效率偏低；底层使用char[]存储
    StringBuilder:可变的字符序列：jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储

    源码分析：
    String str = new String(); //new char[0];
    String str1 = new String("abc"); //new char[]{'a', 'b', 'c'}
    StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16];底层创建了一个长度是16的数组
    System.out.println(sb1.length()); //0
    sb1.append('a'); //value[0] = 'a';
    sb1.append('b'); //value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];

    //问题1：System.out.println(sb2.length()); //3
    //问题2：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
            默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity) 用形参指定容量


     */
    @Test
    public void test1(){
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.setCharAt(0, 'm');//String没有setCharAt方法
        System.out.println(stringBuffer);
        String s1 = new String("haha");

    }

//    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
//    StringBuffer delete(int start,int end)：删除指定位置的内容
//    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
//    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
//    StringBuffer reverse() ：把当前字符序列逆转
//    public int indexOf(String str)
//    public String substring(int start,int end)
//    public int length()
//    public char charAt(int n )
//    public void setCharAt(int n ,char ch)
//    总结：
//        增：append(xxx)
//        删：delete(int start,int end)
//        改：setCharAt(int n ,char ch);replace(int start, int end, String str)
//        查：charAt(int n )
//        插：insert(int offset, xxx)
//        长度：length();
//        遍历：for() + charAt()
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);//11
        s1.delete(2, 4);
        s1.replace(2, 4, "hello");
        s1.insert(1, true);
        System.out.println(s1);//ab1
        System.out.println(s1.length()); //11
        s1.reverse();
        System.out.println(s1);
        String s2 = s1.substring(1, 3);
        System.out.println(s2);
        s1.setCharAt(1, 'm');
        System.out.println(s1);
    }
    @Test
    public void test3(){
        /*
        对比String / StringBuffer / StringBuilder
        效率从高到低：StringBuilder / StringBuffer / String
         */
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i; }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}
