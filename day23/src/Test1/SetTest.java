package Test1;/*
@author Serenity
@create 2022-02-14-12:32
*/

import org.junit.Test;

import java.util.*;

/**
 * |---Collection接口：单列集合，用来存储一个一个的对象。
 *          |---set接口：存储无序的，不可重复的数据。  ---> 高中讲的”集合“
 *              |---HashSet :作为Set接口的主要实现类；线程不安全的；可存储null值
 *                  |---LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                                     对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *              |---TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 *  1. Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *
 *  2. 要求：向Set中添加数据，其所在的类一定要重写hashCode()和equals()
 *     要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *     重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 */
public class SetTest {
    /**
     * 一、Set存储无序的、不可重复的数据
     * 以HashSet为例说明：
     * 1. 无序性：不等于随机性。存储的数据在底层数组并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。
     *
     * 2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true。即：相同的元素只能添加一个。
     *
     * 二、添加元素的过程，以HashSet为例：
     *  我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     *  此哈希值接着通过某种算法计算在hashSet在底层数组中的存放位置（即为，索引位置），判断
     *  数组此位置上时候已经有元素：
     *      如果此位置上没有其他元素，则元素a添加成功。 ---> 情况1
     *      如果此位置上有其他元素b（或者以链表形式存在的多个元素），则比较元素a与元素b的hash值：
     *          如果hash值不同，则元素a添加成功。 ---> 情况2
     *          如果hash值相同，进而需要调用元素a所在类的equals()方法：
     *              equals()返回true，元素a添加失败
     *              equals()返回false，元素a添加成功 ---> 情况3
     *
     *  对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储。
     *  jdk7：元素a放到数组中，指向原来的元素。
     *  jdk8：原来的元素在数组中，指向元素a
     *  总结：七上八下
     *  hashSet底层是：数组加链表的结构。
     */

    @Test
    public void test(){
        HashSet linkedHashSet = new HashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(666);
        linkedHashSet.add(666);
        linkedHashSet.add("超强，加油要无敌");
        linkedHashSet.add(new User("John", 21));
        linkedHashSet.add(new User("John", 21));
        linkedHashSet.add("aA");

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
        //目的：（优点）对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test1(){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(666);
        linkedHashSet.add(666);
        linkedHashSet.add("超强，加油要无敌");
        linkedHashSet.add(new User("John", 21));
        linkedHashSet.add(new User("John", 21));
        linkedHashSet.add("aA");

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    /**
     * 1. 向TreeSet中添加的数据，要求是相同类的对象
     * 2. 两种排序方式：自然排序（实现Comparable接口）和定制排序（Comparator）
     *
     * 3. 自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()。
     *
     * 4. 定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals()。
     */
    @Test
    public void test2(){
        TreeSet linkedHashSet = new TreeSet();
//        java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //不能添加不同类的对象
//        linkedHashSet.add(123);
//        linkedHashSet.add(666);
//        linkedHashSet.add(666);
//        linkedHashSet.add("超强，加油要无敌");
//        linkedHashSet.add(new User("John", 21));
//        linkedHashSet.add(new User("John", 21));
//        linkedHashSet.add("aA");

        //从小到大
//        linkedHashSet.add(-9);
//        linkedHashSet.add(-98);
//        linkedHashSet.add(88);
//        linkedHashSet.add(6);
//        linkedHashSet.add(1);
//        linkedHashSet.add(666);
        //举例二
//        linkedHashSet.add("ha");
//        linkedHashSet.add("我强无敌");
//        linkedHashSet.add("富得流油");
//        linkedHashSet.add("富可敌国");
//        linkedHashSet.add("加油啊");
//        linkedHashSet.add("heihei");

        //举例三
        linkedHashSet.add(new Person("Jack", 21));
        linkedHashSet.add(new Person("Tom", 24));
        linkedHashSet.add(new Person("Tom", 22));
        linkedHashSet.add(new Person("John", 23));
        linkedHashSet.add(new Person("Bob", 26));
        linkedHashSet.add(new Person("Mike", 24));

        Iterator iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        Comparator comparator = new Comparator() {
            @Override
            //定制排序(Comparator)实现先年龄从小到大，后按姓名从小到大
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int compare = Integer.compare(p1.getAge(), p2.getAge());
                    if (compare != 0){
                        return compare;
                    }else{
                        return p1.getName().compareTo(p2.getName());
                    }
                }else {
                    throw new RuntimeException("参数类型有误。");
                }
            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new Person("Jack", 21));
        treeSet.add(new Person("Tom", 24));
        treeSet.add(new Person("Tom", 22));
        treeSet.add(new Person("John", 23));
        treeSet.add(new Person("Bob", 26));
        treeSet.add(new Person("Mike", 24));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
