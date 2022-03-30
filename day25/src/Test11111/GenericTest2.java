package Test11111;/*
@author Serenity
@create 2022-02-16-20:22
*/

import Test1111.DAO;
import org.junit.Test;

import java.util.*;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 */
public class GenericTest2 {
    /**
     * 1.泛型在继承方面的体现
     *  虽然类A是类B的父类，但G<A>和G<B>不具备子父类关系，二者是并列关系。
     *  补充：类A是类B的父类(接口也可)，A<G>是 B<G> 的父类。
     */
    @Test
    public void test(){
        Object obj = null;
        String str = null;
        obj = str;  //子类可以赋值给父类

        Object[] obj1 = null;
        String[] str1 = null;
        obj1 = str1;

        //        Date date = new Date();
        //编译不通过
//        str = date;

        List<Object> list = null;
        List<String> list1 = new ArrayList<String>();
        //此时list和list1不是子父类关系
//        list = list1;  //编译不通过

        /**
         * 反证法：
         * 假设list = list1
         * 此时list.add(123);导致混入非String的数据，出错。
         */
        show(list);
//        show(list1); //编译不通过，除非声明一个show(List<String> list){}方法

    }
    public void show(List<Object> list){

    }

    @Test
    public void test1(){
        List<String> list = null; //接口
        AbstractList<String> list1 = new AbstractList<String>() {
            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        }; //抽象类
        ArrayList<String> list2 = new ArrayList<>(); //AbstractList的子类
        list = list2;
        list1 = list2;

    }

    @Test
    public void test3(){
        /**
         * 通配符的使用：
         * 通配符：?
         * 类A是类B的父类，G<A>和 G<B>是没有关系的，二者共同的父类是：G<?>
         */
        ArrayList<Object> list1 = null;
        ArrayList<Integer> list2 = null;
        List<?> list = null;
        list = list1;
        list = list2;

//        print(list);
//        print(list1);
//        print(list2);

        //添加（写入）：对于List<?>就不能向其他内部添加数据。
        //除了添加null之外。
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("666");
        list3.add("哈哈");
        list3.add("888");
        list3.add("嘿嘿");
        list = list3;


//        list.add("a");
        list.add(null);

        //获取（读取）：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);
//        print(list);


    }

    //如果想写一个通用的方法
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        /**
         * 有限制条件的通配符的使用：
         *      ? extends A:
         *          G <? extends A> 可以作为G<A> 和 G<B>的父类，其中B是A的子类
         *      ? super A:
         *          G<? super A> 可以作为G<A> 和 G<B>的父类，其中B是A的父类
         */

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Person> list3 = new ArrayList<>();
        List<Student> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4; // list1可以加载list3和list4
//        list1 = list5; //编译失败

        list2 = list3;
//        list2 = list4; //编译失败
        list2 = list5;

        //读取数据
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);
        list2 = list3;

        //编译不通过
//        Person p1 = list2.get(0);
        Object o1 = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student()); //? extends A 代表类的(-∞, A]，有可能list1是Student的子类，所以失败
//        list1.add(new Person()); //编译不通过

        list2.add(new Person());
        list2.add(new Student()); //? super A 代表类的[A, ∞)，则类A和类A的子类数据都是可以添加成功的

    }
}
