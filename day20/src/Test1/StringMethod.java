package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-10:55
 int length()：返回字符串的长度： return value.length
 char charAt(int index)： 返回某索引处的字符return value[index]
 boolean isEmpty()：判断是否是空字符串：return value.length == 0
 String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 String trim()：返回字符串的副本，忽略前导空白和尾部空白
 boolean equals(Object obj)：比较字符串的内容是否相同
 boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
小写
 String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 int compareTo(String anotherString)：比较两个字符串的大小
 String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
beginIndex开始截取到最后的一个子字符串。
 String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。

*/

import org.junit.Test;

import java.util.Locale;

public class StringMethod {
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
//        System.out.println(s1.charAt(10)); //StringIndexOutOfBoundsException
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变的，仍然为原来的字符串
        System.out.println(s2);//改成小写以后的字符串

        String s3 = "   he llo  world  ";
        String s4 = s3.trim();
        System.out.println("++++++++++" + s3 + "++++++++++");
        System.out.println(s4);

    }
    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2)); //false
        System.out.println(s1.equalsIgnoreCase(s2));  //true

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = "abd";
        System.out.println(s5.compareTo(s6)); //涉及到字符串排序

        String s7 = "巴拉巴拉小魔仙黑暗之神古娜拉魔法变";
        String s8 = s7.substring(7);
        System.out.println(s7);
        System.out.println(s8);
        String s9 = s7.substring(7, 11); //左闭右开
        System.out.println(s9);

    }
}
