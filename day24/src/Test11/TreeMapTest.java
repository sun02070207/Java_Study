package Test11;/*
@author Serenity
@create 2022-02-15-20:57
*/

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    //自然排序Comparable
    @Test
    public void test(){
        TreeMap treeMap = new TreeMap();
        Person p1 = new Person("Tom", 18);
        Person p2 = new Person("Jerry", 66);
        Person p3 = new Person("Mike", 8);
        Person p4 = new Person("Hurry", 68);
        Person p5 = new Person("Serenity", 28);
        treeMap.put(p1, 88);
        treeMap.put(p2, 118);
        treeMap.put(p3, 100);
        treeMap.put(p4, 68);
        treeMap.put(p5, 88);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Map.Entry entry = (Map.Entry) key;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
    //定制排序Comparator()
    @Test
    public void test1(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }else {
                    throw new RuntimeException("数据类型错误！");
                }
            }
        };
        TreeMap treeMap = new TreeMap(comparator);
        Person p1 = new Person("Tom", 18);
        Person p2 = new Person("Jerry", 66);
        Person p3 = new Person("Mike", 8);
        Person p4 = new Person("Hurry", 68);
        Person p5 = new Person("Serenity", 28);
        treeMap.put(p1, 88);
        treeMap.put(p2, 118);
        treeMap.put(p3, 100);
        treeMap.put(p4, 68);
        treeMap.put(p5, 88);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Map.Entry entry = (Map.Entry) key;
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

}
