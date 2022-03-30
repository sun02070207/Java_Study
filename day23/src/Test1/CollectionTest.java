package Test1;/*
@author Serenity
@create 2022-02-11-16:50
*/

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.*;

/**
 *
 * 一、集合框架的概述
 * 1. 集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 *   说明：此时的存储，主要指内存层面的存储，不涉及持久化的存储（.txt, .jpg, avi, 数据库中）
 *
 * 2.数组在存储数据方面的特点：
 *      > 一旦初始化之后，其长度就确定了
 *      > 数组一旦定义好，其元素的类型也就确定了。我们就只能操作指定类型的数据。
 *      比如：String[] arr, int[] i, Object[] obj;
 *
 * 3.数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作非常不便，效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性和方法
 *      > 数组存储的数据的特点：有序性，可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |---Collection接口：单列集合，用来存储一个一个的对象。
 *          |---list接口: 存储有序的，可重复的数据。  ---> "动态"数组
 *              |---ArrayList \ LinkedList \ Vector
 *
 *          |---set接口：存储无序的，不可重复的数据。  ---> 高中讲的”集合“
 *              |---HashSet \ LinkedHashSet \ TreeSet
 *      |---Map接口：双列集合，用来存储一对一对(key-value)的数据。  ---> 高中讲的”函数“：y = f(x)
 *                  一个key不可以对应多个value，一个value可以被不同的key对应
 *              |---HashMap \ LinkedHashMap \ TreeMap \ Hashtable \ Properties
 *
 *
 *  三、Collection接口中的方法的使用
 *
 */

public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

//        add(Object obj)：将元素obj添加到集合coll中
        coll.add("六六六");
        coll.add(100); //自动装箱
        coll.add("萨瓦迪卡");

//        int size()：获取添加的元素的个数
        System.out.println(coll.size());

//        addAll(Collection coll1)：将coll1集合中的元素添加到coll集合中
        Collection coll1 = new ArrayList();
        coll1.add("用来给coll添加东西的");
        coll1.add("1次");
        coll1.add(new Date());
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
//        System.out.println(coll.getClass());

//        clear()：清空集合中的元素
        coll.clear();

//        isEmpty()：判断当前集合是否为空
        System.out.println(coll.isEmpty());
        System.out.println(coll1.isEmpty());
    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add("黑猫");
        collection.add("白猫");
        collection.add(123);
        collection.add(999);

//        向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()方法
//        collection.contains(Object obj)：判断当前集合是否包含obj
//        我们在判断时会调用obj对象所在类的equals
        System.out.println(collection.contains(123));//true
//        collection.add(new String());

        Person p = new Person("Tom", 21);
        collection.add(p);
        System.out.println(collection.contains(p));//true
        collection.add(new Person("Jerry", 18));
        System.out.println(collection.contains(new Person("Jerry", 18)));//false, 如果重写Person的equals方法可以变为true

        System.out.println("*********************");

//        collection.containsAll(Collection coll1)：判断形参coll1中所有元素是否都存在于当前集合
        Collection coll1 = Arrays.asList(123,789);
        Collection coll2 = Arrays.asList(123,999);
        System.out.println(collection.containsAll(coll1));//false
        System.out.println(collection.containsAll(coll2));//true
    }

    @Test
    public void test3(){

//        remove(Object obj)：从当前集合中移除obj元素。
        Collection collection = new ArrayList();
        collection.add("黑猫");
        collection.add("白猫");
        collection.add(123);
        collection.add(999);
        collection.add(false);

        collection.remove(1239);
        collection.remove("黑猫");
        System.out.println(collection);//[白猫, 123, 999, false]

        //removeAll(Collection coll1)：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123, 9999);
        collection.removeAll(coll1);
        System.out.println(collection); //[白猫, 999, false]

    }

    @Test
    public void test4(){
        Collection collection = new ArrayList();
        collection.add("黑猫");
        collection.add("白猫");
        collection.add(123);
        collection.add(999);
        collection.add(false);
//        collection.add(new Person("Jerry", 18));


        Collection coll1 = Arrays.asList(123, 456, 999);
//        retainAll(Collection coll1)：交集，获取当前集合与coll1集合的交集，并返回给当前集合
//        collection.retainAll(coll1);
//        System.out.println(collection);

//        equals(Object obj)：判断当前集合和形参集合的元素是否相同

        Collection collection1 = new ArrayList();
        collection1.add("黑猫");
        collection1.add("白猫");
        collection1.add(123);
        collection1.add(999);
        collection1.add(false);
//        collection1.add(new Person("Jerry", 18));

        System.out.println(collection.equals(collection1));
    }

    @Test
    public void test5(){
        Collection collection = new ArrayList();
        collection.add("黑猫");
        collection.add("白猫");
        collection.add(123);
        collection.add(999);
        collection.add(false);

//        hashCode()：返回当前对象的哈希值
        System.out.println(collection.hashCode());

//        集合转换为数组：toArray()
        Object[] obj = collection.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }

        System.out.println("*****************");

//        拓展：数组转换为集合：调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "B"});
        System.out.println(list); //[AA, B]

        List<int[]> list1 = Arrays.asList(new int[]{1, 2, 4, 6, 9});
        System.out.println(list1); //[[I@4dcbadb4]

        List<Integer> list2 = Arrays.asList(new Integer[]{1, 2, 6, 8});
        System.out.println(list2);

//        iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}
