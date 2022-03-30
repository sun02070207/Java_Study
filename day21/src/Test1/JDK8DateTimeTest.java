package Test1;/*
@author Serenity
@create 2022-01-25-11:38
*/

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class JDK8DateTimeTest {
    @Test
    public void test(){
//        偏移量
//        Date date = new Date(2022, 1, 25);//Sat Feb 25 00:00:00 CST 3922
        Date date = new Date(2022 - 1900, 1 - 1, 25);//Tue Jan 25 00:00:00 CST 2022

        System.out.println(date);
    }
//    LocalDate、LocalTime、LocalDateTime类
//    说明：
//    1. LocalDateTime相较于LocalDate、LocalTime，使用频率要高
//    2.类似于Calendar
    @Test
    public void test1(){
//        查看当前日期、时间、日期与时间
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

//        of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022,1,28,14,20);
        System.out.println(localDateTime1);

//        getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getMonthValue());

//        withXxx设置相关属性
//        Local类具有不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(28);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(22);
        System.out.println(localDateTime3);

//        加减，仍具有不可变性
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusMonths(4);
        System.out.println(localDateTime5);

    }
    /*
    Instant的使用
    类似于java.util.Date

     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant); //本初子午线时间

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 --->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1643109450325L);
        System.out.println(instant1);

    }
    //DateTimeFormatter的使用：用来格式化或解析日期、时间
//    类似于SimpleDateFormat
    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);
        //解析：字符串--->日期
        TemporalAccessor parse = dateTimeFormatter.parse("2022-01-25T19:31:16.323");
        System.out.println(parse);

//        方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        /*
        本地化相关的格式。如：ofLocalizedDateTime()
        FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT：适用于LocalDate Time

        本地化相关的格式。如；ofLocalizedDate()
        FormatStyle.FULL/FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT：适用于LocalDate
        */
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String format1 = dateTimeFormatter1.format(localDateTime1);
        System.out.println(localDateTime1);
        System.out.println(format1);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str4 = dateTimeFormatter2.format(localDateTime1);
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter1.parse("2022-1-25 19:45:16");
        System.out.println(parse1);
        TemporalAccessor parse2 = dateTimeFormatter2.parse("2022年1月25日 星期二");
        System.out.println(parse2);

//        方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = dateTimeFormatter3.format(localDateTime1);
        System.out.println(localDateTime1);
        System.out.println(format2);//2022-01-25 07:53:41
        //解析
        TemporalAccessor parse3 = dateTimeFormatter3.parse("2022-01-25 07:53:41");
        System.out.println(parse3);


    }

}
