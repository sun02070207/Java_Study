package Test1;/*
@author Serenity
@create 2022-02-12-16:24
*/

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;
import org.junit.Test;

import java.util.*;

/**
 * 1. |---Collection接口：单列集合，用来存储一个一个的对象。
 *          |---list接口: 存储有序的，可重复的数据。  ---> "动态"数组,替换原有的数组
 *              |---ArrayList：作为List接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData存储
 *              |---LinkedList：对于频繁的插入、删除操作，使用此类比ArrayList效率高；底层使用双向链表存储，
 *              |---Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 * 2. ArrayList的源码分析：
 * 2.1 jdk7的情况下：
 *  底层不变，使用Object[] elementData存储
 *  ArrayList list = new ArrayList(); //底层创建了长度是10的Object[]数组elementData
 *  list.add(123); //elementData[0] = new Integer(123);
 *  ...
 *  list.add(11); //如果此次添加导致底层elementData数组容量不够，则扩容。
 *  默认情况，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *  结论：开发中建议使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 * 2.2 jdk8的情况下
 *  ArrayList list = new ArrayList(); // 底层Object[] elementData初始化为{}，并没有创建长度
 *  list.add(123); //第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]
 *  ...
 *  后续的添加与扩容与jdk7相同
 *
 *  2.3 小结：jdk7中的ArrayList的对象的创建类似于单例设计模式的饿汉式，而jdk8中的ArrayList的对象创建类似于单例设计模式的懒汉式。
 *
 *
 * 3. LinkedList的源码分析：
 *  LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *  list.add(123); //将123封装到Node中，创建Node对象。
 *
 *  其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 *          E item;
 *          Node<E> next;
 *          Node<E> prev;
 *
 *          Node(Node<E> prev, E element, Node<E> next) {
 *              this.item = element;
 *              this.next = next;
 *              this.prev = prev;
 *          }
 *      }
 *
 *
 * 4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *      在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *
 *
 * 5. List接口中的常用方法
 * 面试题：ArrayList \ LinkedList \ Vector三者的异同？
 *
 * 相同：三个类都实现了List接口，存储数据的特点相同：存储有序的，可重复的数据。
 * 不同：如上2-4
 */
public class ListTest {
    //void add(int index, Object ele):在index位置插入ele元素
    //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    //Object get(int index):获取指定index位置的元素
    //int indexOf(Object obj):返回obj在集合中首次出现的位置
    //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    //Object remove(int index):移除指定index位置的元素，并返回此元素
    //Object set(int index, Object ele):设置指定index位置的元素为ele
    //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开的子集合


    /*总结：常用方法
      增：add(Object obj)
      删：remove(int index) / remove(Object obj)
      改：set(int index, Object ele)
      查：get(int index)
      插：add(int index, Object ele)
      长度：size()
      遍历：① Iterator迭代器方式
           ② 增强for循环
           ③ 普通循环
    */


    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(false);
        list.add(123);
        list.add(666);
        list.add(new Person("Tom", 21));
        list.add(666);

        System.out.println(list);
        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1, 888);
        System.out.println(list);
        System.out.println("**********************");

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);
        System.out.println("**********************");

        list.addAll(1, list1);
        System.out.println(list);
        System.out.println(list.size()); //12

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

    }

    @Test
    public void test1(){

        ArrayList list = new ArrayList();
        list.add(false);
        list.add(123);
        list.add(666);
        list.add(new Person("Tom", 21));
        list.add(666);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置，如果不存在返回-1.
        int i = list.indexOf(123);
        System.out.println(i);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int i1 = list.lastIndexOf(666);
        System.out.println(i1);

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        Object set = list.set(1, 888);
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开的子集合，原List不变
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);


    }

    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(true);
        arrayList.add("超强，超无敌");
        arrayList.add(666);

//        ① Iterator迭代器方式
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("****************");
//        ② 增强for循环
        for (Object obj:
             arrayList) {
            System.out.println(obj);
        }
        System.out.println("****************");
//        ③ 普通循环
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }

}
