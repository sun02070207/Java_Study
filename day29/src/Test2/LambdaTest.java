package Test2;/*
    @description
    @author Serenity
    @create 2022-02-25-14:02
*/

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    //Lambda
    @Test
    public void test(){
        Runnable runnable = new Runnable() {//提供一个实现Runnable()的匿名实现对象
            @Override
            public void run() {
                System.out.println("实习实习");
            }
        };
        runnable.run();

        //lambda（）表达式
        Runnable runnable1 = () -> System.out.println("找工作，顺利毕业");
        runnable1.run();
    }

    @Test
    public void test1(){
        //语法格式六：当 Lambda体只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = c1.compare(10, 21);
        System.out.println(compare); //-1

        //Lambda表达式的写法
        Comparator<Integer> c2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare1 = c2.compare(30, 29);
        System.out.println(compare1); //1
        //方法引用
        Comparator<Integer> c3 = Integer::compare;
        int compare2 = c3.compare(30, 22);
        System.out.println(compare2);  //1

    }
    @Test
    public void test2(){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("强无敌");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };

        consumer1.accept("输出");

        //语法格式三：数据类型可以省略
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };

        consumer2.accept("语法表达式三，数据类型可以省略");

        // 语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
        Consumer<String> consumer3 = s -> {
            System.out.println(s);
        };

        consumer3.accept("语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略");

    }

    //语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test3(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };

        Comparator<Integer> com1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
    }

}
