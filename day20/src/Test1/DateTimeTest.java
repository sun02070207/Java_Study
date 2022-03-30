package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-20:21

    JDK 8之前日期和时间的API测试
*/

import org.junit.Test;

import javax.tools.JavaCompiler;
import java.util.Date;

public class DateTimeTest {
    @Test
    public void test(){
     /*
     System类中的currentTimeMillis()
      */
        //System类提供的public static long currentTimeMillis()
        //用来返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        long time = System.currentTimeMillis();
        //称为时间戳
        System.out.println(time);
    }
    @Test
    public void test1(){
        /*
        java.util.Date类
                |---java.sql.Date类

        1.两个构造器的使用
        >构造器一：Date():创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象

        2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

        3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >sql.Date --> util.Date对象（多态）
        >如何将util.Date对象转换为java.sql.Date对象


         */
        //构造器一：Date()：创建了一个对应当前时间Date对象
        Date uDate = new Date();
        System.out.println(uDate.toString());//Sun Jan 16 21:20:35 CST 2022
        System.out.println(uDate.getTime());//1642339304794

        //构造器二：
//        new Date(2022, 1, 16);画横线表示过时了
        Date date = new Date(1642339304794L);
        System.out.println(date.toString());

        //创建java.sql.Date对象
        java.sql.Date date1 = new java.sql.Date(4619867976489L);
        System.out.println(date1);//2116-05-26

        //如何将util.Date对象转换为java.sql.Date对象
        //情况1
//        Date date2 = new java.sql.Date(16764344468L);
//        java.sql.Date date3 = (java.sql.Date)date2;

        //情况2
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5.getClass());
    }
}
