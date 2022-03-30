package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-14:54

    涉及到String类与其他结构之间的转换
*/

import org.junit.Test;

public class StringTransform {
    /*
    复习：
    String 与基本数据类型、包装类之间的转换

    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)

    基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)



     */




    @Test
    public void test(){
        String s1 = "86";
        Integer i1 = Integer.parseInt(s1);
        int num = i1.intValue();
        System.out.println(num);
        String s = String.valueOf(num);
        System.out.println(s);
        String s2 = num + "";
        String s3 = String.valueOf(num);
        System.out.println(s2 == s); //false
        System.out.println(s2.equals(s3)); //true
    }
    /*
    String 与 char[] 之间的转换

    String --> char[]:调用String的toCharArray()

    char[] --> String:调用String的构造器

     */
    @Test
    public void test1(){
        String str1 = "abc123"; //a21cb3
        char[] charArray = str1.toCharArray();
        int j = charArray.length;
//        System.out.println(j);
        char[] charArray1 = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i == 0){
                System.out.print(charArray[i]);
            }else if (i == charArray.length - 1){
                System.out.print(charArray[i]);
            }
            else {
                charArray1[j - 1] = charArray[i];
                j--;
                System.out.print(charArray1[j - 1]);
            }
        }
        System.out.println();
        System.out.println(charArray);
        System.out.println(charArray1);
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s = new String(arr);
        System.out.println(s);

    }

}
