package Exer;/*
@author Serenity
@create 2022-02-15-16:26
*/


import org.junit.Test;

import java.util.HashSet;

public class CollectionTest {
    //Set面试题测试，注意Person重写了hashCode()和equals()方法
    @Test
    public void test(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);  // 因为remove的p1，是计算new Person(1001,"CC")的哈希值，所以大概率与new Person(1001,"AA")不一样，而p1.name = "CC";是直接将原来的索引位置的p1的name进行修改。故而结果为[Person{name='BB', age=1002}, Person{name='CC', age=1001}]
        set.add(new Person(1001,"CC"));
        System.out.println(set); //从新计算哈希值[Person{name='BB', age=1002}, Person{name='CC', age=1001}, Person{name='CC', age=1001}]
        set.add(new Person(1001,"AA"));
        System.out.println(set); //从新运行equals()方法后，得[Person{name='BB', age=1002}, Person{name='CC', age=1001}, Person{name='CC', age=1001}, Person{name='AA', age=1001}]
    }

}
