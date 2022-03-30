package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-14:14
 boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
子字符串是否以指定前缀开始
 boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
时，返回 true
 int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
现处的索引，从指定的索引开始
 int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
一次出现处的索引，从指定的索引开始反向搜索
注：indexOf和lastIndexOf方法如果未找到都是返回-1


*/

import org.junit.Test;

public class StringMethod2 {
    @Test
    public void test(){
        String str = "helloWorld";
        boolean b1 = str.endsWith("Ld"); //是否以指定字符串截至
        System.out.println(b1);//false

        boolean b2 = str.startsWith("he");//是否以指定字符串开始
        System.out.println(b2);//true

        boolean b3 = str.startsWith("lo", 3); //是否以索引位置3的指定字符串开始
        System.out.println(b3);//true

        String str1 = "wo";
        String str2 = "helloWworld";

        boolean b4 = str.contains(str1);
        System.out.println(b4);//false 严格区分大小写
        boolean b5 = str2.contains(str1);
        System.out.println(b5); //true

        System.out.println(str.indexOf("Wor")); //5
        System.out.println(str.indexOf("W", 6)); //-1

        String str3 = "helloorhiorheiorWww";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or", 10));

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str

    }
}
