package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-16:14

    String 与 byte[]之间的转换
    String --> byte[]:调用String的getBytes()

*/

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringTranform1 {
//    String 与 byte[]之间的转换
//    String --> byte[]:调用String的getBytes()

//    编码： 字符串 --> 字节（看得懂 --> 看不懂的二进制数据）
//    解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 --> 看得懂）
//    说明：解码时，要求解码使用的字符集必须与编码时的字符集一致，否则会出现乱码
    @Test
    public void test() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码
        System.out.println(Arrays.toString(bytes));

//        try {
//            byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码
//            System.out.println(Arrays.toString(gbks));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        byte[] gbks = str1.getBytes("gbk");
        System.out.println("*****************");
        String s1 = new String(bytes);//使用默认的字符集，进行解码
        System.out.println(s1);
        String s2 = new String(gbks);
        System.out.println(s2); //出现乱码，原因：编码集与解码集不一样
        String s3 = new String(gbks, "gbk");
        System.out.println(s3);
    }
}
