package Test1;/*
@author Serenity
@create 2022-01-25-9:14

jdk 8之前的日期时间的API测试
1.System类中currentTimeMillis();
2.java.util.Date和子类java.sql.Date
3.SimpleDateFormat
4.Calendar

*/

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {
    /*
    SimpleDateFormat类的使用：SimpleDateFormat类对日期Date类的格式化和解析

    1.两个操作：
    1.1格式化： 日期 ---> 字符串
    1.2解析：  格式化的逆过程， 字符串--->日期

    2.SimpleDateFormat类的实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat空参构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //格式化
//        1.实例化SimpleDateFormat类
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat();
//        2.创建格式化需要的类
        Date date = new Date();
        System.out.println(date);
//        3.调用格式化类format
        String sdf = simpleDateFormat.format(date);
        System.out.println(sdf);

        //解析
        String str = "22-1-28 上午9:27";
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1);

//        *******按照指定模式************
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd,hh-mm-ss");
        //使用带参构造器按想要的格式格式化
        String format = simpleDateFormat1.format(date);
        System.out.println(format);
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则报异常,parse解析完，返回的是Date类
        String date2 = new String("2028-01-28,10-20-15");
        Date date3 = simpleDateFormat1.parse(date2);
        System.out.println(date3);
    }
    /*
    练习1：字符串“2022-01-08”转换为java.sql.Date
     */
    @Test
    public void test1() throws ParseException {
        String birth = "2022-01-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
        System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(sdf.parse(birth).getTime());
        System.out.println(birthDate + "\t" + birthDate.getClass());
    }
    /*
    练习二:"三天打鱼两天晒网" 1990-01-01  xxxx-xx-xx打鱼？晒网？

    举例：2022-01-28 ？ 总天数
    总天数 % 5 == 1，2，3：打鱼
    总天数 % 5 == 4，0：晒网

    总天数的计算：
    方式一：(date2.getTime - date1.getTime) / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01 ---> 2021-12-31 (计算整年。注意闰年天数加n) + 2022-01-01 ---> 2020-01-28
     */

    /*
    Calendar日历类（抽象类）的使用
     */
    @Test
    public void test2(){
//        1.实例化
//        方式一：创建其子类(GregorianCalendar)的对象
//        方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

//        2.常用方法
//        get()
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

//        set()
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
//        add()
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
//        getTime()
        Date date = calendar.getTime();
        System.out.println(date);
//        setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        int j = calendar.get(Calendar.THURSDAY);
        System.out.println(j+ "))))))");
    }
}
