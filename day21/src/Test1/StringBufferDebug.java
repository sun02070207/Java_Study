package Test1;/*
@author Serenity
@create 2022-01-17-23:00
*/

import org.junit.Test;

public class StringBufferDebug {
    @Test
    public void test(){
        String s = new String("null");
        String s1 = null;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer.append(s);
        stringBuffer1.append(s1);
        System.out.println(stringBuffer.length());//4
        System.out.println(stringBuffer1.length());//4
        System.out.println(stringBuffer);//null
        System.out.println(stringBuffer1);//null

        StringBuffer stringBuffer2 = new StringBuffer(s);
        System.out.println(stringBuffer2);//null

        StringBuffer stringBuffer3 = new StringBuffer(s1);//NullPointerException 直接赋值null的变量会报错
        System.out.println(stringBuffer3);  //NullPointerException

    }
}
