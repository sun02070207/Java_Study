package Test111;/*
@author Serenity
@create 2022-02-16-16:38
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *
 *  1.关于自定义泛型类、泛型接口
 *
*/
public class GenericTest1 {

    @Test
    public void test(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT("123");
        order.setOrderT(123);
        System.out.println(order.getClass());
        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("Tom", 1, "嘿嘿");
        order1.setOrderT("666");
        System.out.println(order1);
    }

    @Test
    public void test1(){
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);
        //jdk7.0新特性，类型推断
        SubOrder1<String> s1 = new SubOrder1<>();
        s1.setOrderT("haha");
    }


    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        //    泛型不同的引用不能相互赋值。
//        list = list1;  //编译过不了
        Person p1 = null;
        Person p2 = null;
        p1 = p2;
    }

    @Test
    //测试泛型方法
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 6, 8, 9, 86};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);

    }

}
