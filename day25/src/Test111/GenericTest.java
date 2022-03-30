package Test111;/*
@author Serenity
@create 2022-02-16-15:34
*/


import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用：
 * 1.jdk5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *      总结：① 集合接口或集合类在jdk5.0时都修改为带泛型的结构
 *      ② 在实例化集合类时，可以指明具体的泛型类型
 *      ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法，属性，构造器等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *         比如：add(E e) ---> 实例化以后：add(Integer e)
 *      ④ 泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型时，用包装类进行替换。
 *      ⑤ 如果实例化时，没有指明泛型的类型。默认使用java.lang.Object类型。
 *
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法 ----> 见GenericTest1和Order
 *
 */
public class GenericTest {

    @Test
    public void test(){
        //在集合中使用泛型之前的情况
        ArrayList list = new ArrayList();
        //需求：放置学生成绩
        list.add(100);
        list.add(99);
        list.add(100);
        list.add(89);
        //问题1：类型不安全
        list.add("Tom");

        for (Object score:
             list) {
            //问题2，强转时，可能会报异常ClassCastException
            int intScore = (int) score;
            System.out.println(intScore);
        }

    }

    @Test
    public void test1(){
        //在集合中使用泛型的情况:以ArrayList举例
        ArrayList<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(98);
        list.add(100);
        list.add(89);
        //编译时，就会进行类型检查，保证数据安全
//        list.add("Tom");

//        方式1
//        for (Integer score:
//             list) {
//            //避免了强转操作
//            int intScore = score;
//            System.out.println(intScore);
//        }

//        方式2
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        //在集合中使用泛型的情况：以HashMap为例
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //jdk7.0的新特性：类型推断
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 23);
        map.put("Jerry", 25);
        map.put("Mike", 13);
        map.put("Honey", 23);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "--->" + value);
        }
    }
}
