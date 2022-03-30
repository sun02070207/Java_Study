package Test111;/*
@author Serenity
@create 2022-02-16-16:35
*/

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口；泛型方法
 *  类的内部结构就可以使用类的泛型
 *
 */
public class Order<T> {
    String name;
    int id;
    //类的内部结构就可以使用类的泛型
    T orderT;
    public Order(){
//        不能使用new E[]
//        T[] arr = new T[10]; //编译不通过
        T[] arr =(T[]) new String[10];
//        System.out.println(arr.length);
    }

    public Order(String name, int id, T orderT) {
        this.name = name;
        this.id = id;
        this.orderT = orderT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //如下三个方法getOrderT()、setOrderT(T orderT)、toString()都不是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", orderT=" + orderT +
                '}';
    }

//    public static void show(T orderT){
        //静态方法中不能使用类的泛型，由于静态方法在未实例化时就需要确认，而泛型时在实例化时才确认。
//        System.out.println(orderT);
//
//    }
    public void show(){
        //异常类不能是泛型的
        //编译不通过
//        try {
//
//        }catch (T t){
//
//        }
    }
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所属的类是不是泛型都没有关系
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法是确定的。并非在实例化时确定的。
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:
             arr) {
            list.add(e);
        }
        return list;
    }
}
