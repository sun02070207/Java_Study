package Test1;/*
@author Serenity
@create 2022-02-11-23:18
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合数组的遍历操作，使用迭代器Iterator接口
 * 1.内部方法：hasNext()和next()抽象方法
 * 2.Iterator 仅用于遍历集合，Iterator 本身并不提供承装对象的能力。如果需要创建Iterator 对象，则必须有一个被迭代的集合。
 * 3.内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 *
 *
 */

public class IteratorTest {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(false);
        collection.add(12.3);
        collection.add(666);
        collection.add("顺顺顺");
        collection.add("发发发大财嘿嘿嘿");

        Iterator iterator = collection.iterator();

//        方式一：一个一个next()，开发中不用
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

//        next()位置超出集合size，故报错java.util.NoSuchElementException
//        System.out.println(iterator.next());

//        方式二：for循环，开发中也不常用
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }

//        方式三：使用hasNext()抽象方法，开发中常用
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(false);
        collection.add(12.3);
        collection.add(666);
        collection.add("顺顺顺");
        collection.add("发发发大财嘿嘿嘿");

        Iterator iterator = collection.iterator();

//        错误方式一：由于游标直接下移，此方式会跳元素输出，并且会报异常：java.util.NoSuchElementException
//        while (iterator.next() != null){
//            System.out.println(iterator.next());
//        }

//        错误方式二：会陷入死循环。因为集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
//        默认游标都在集合的第一个元素之前。
        while (collection.iterator().hasNext()){
            System.out.println(collection.iterator().next());
        }
    }

        //remove()方法
        @Test
        public void test2(){
            Collection collection = new ArrayList();
            collection.add(false);
            collection.add(12.3);
            collection.add(666);
            collection.add("顺顺顺");
            collection.add("发发发大财嘿嘿嘿");
            collection.add("Tom");

            Iterator iterator = collection.iterator();
            while (iterator.hasNext()){
    //            iterator.remove();
                Object obj = iterator.next();
                if ("Tom".equals(obj)){
                    iterator.remove();
    //                iterator.remove();
                }
            }

            Iterator iterator1 = collection.iterator();
            while (iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }
}
