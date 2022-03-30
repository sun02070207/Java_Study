package Test11;/*
@author Serenity
@create 2022-02-15-21:48
*/

import org.junit.Test;

import java.util.*;

/**
 *  Collections工具类：操作Collection、Map的工具类
 *
 *  面试题：Collection和Collections的区别？
 *  Collection是存储单例数据的集合的接口，Collections是操作Collection工具类
 *
 *  Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 *  还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 */
public class CollectionsTest {
    @Test
    public void test(){
        /**
         * 排序操作：（均为static方法）
         * reverse(List)：反转 List 中元素的顺序
         * shuffle(List)：对 List 集合元素进行随机排序
         * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
         * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
         * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
         * 查找、替换
         * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
         * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
         * Object min(Collection)
         * Object min(Collection，Comparator)
         * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
         * void copy(List dest,List src)：将src中的内容复制到dest中
         * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
         */
        List list = new ArrayList();
        list.add(1);
        list.add(18);
        list.add(68);
        list.add(26);
        list.add(9);
        System.out.println(list);

//        Collections.reverse(list); //[9, 26, 68, 18, 1]
//        Collections.shuffle(list); //[18, 9, 68, 1, 26]
//        Collections.sort(list); //[1, 9, 18, 26, 68]
//        Collections.sort(list, Comparator);
//        Collections.swap(list, 1, 2); //[1, 68, 18, 26, 9]
//        System.out.println(Collections.max(list)); //68
//        System.out.println(Collections.min(list)); //1
//        System.out.println(Collections.frequency(list, 68)); //1
//        Collections.replaceAll(list, 1, 3); //[3, 18, 68, 26, 9]
        System.out.println(list);

    }
    //void copy(List dest,List src)：将src中的内容复制到dest中
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);
        list.add(18);
        list.add(68);
        list.add(26);
        list.add(9);
        System.out.println(list);

//        java.lang.IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
        //正确的写法
        List<Object> dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        /**
         * Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集
         * 合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全
         * 问题
         */

        //返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);
    }
}
