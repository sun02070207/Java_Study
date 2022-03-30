package Test1;/*
@author Serenity
@create 2022-01-25-22:35

其它常用类的使用
1.System
2.Math
3.BigInteger 和 BigDecimal
*/

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherClassTest {
    @Test
    public void test(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    @Test
    public void testBigInteger() {
        BigInteger bi = new BigInteger("12433241123876278236239846235");
        BigDecimal bd = new BigDecimal("12435.351832156141");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));//java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }







}
