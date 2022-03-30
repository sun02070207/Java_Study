package Test1;/*
@author Serenity
@create 2022-02-12-15:37
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0新增了foreach循环，用于遍历数组和集合
 */

public class ForeachTest {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(false);
        collection.add(12.3);
        collection.add(666);
        collection.add("顺顺顺");
        collection.add("发发发大财嘿嘿嘿");
        collection.add("Tom");

//        对于集合
//        for(集合元素类型 局部变量 ： 集合对象)
//        内部使用的还是iterator迭代器和hasNext()
        for (Object obj : collection){
            System.out.println(obj);
        }

//        对于数组
//        for (数组元素类型 局部变量 ：数组对象)
        int[] i = new int[]{1,3,4,6,8,9,10};

        for (int ints : i){
            System.out.println(ints);
        }
    }

    @Test
    public void test1(){
        String[] strings = new String[]{"GG", "GG", "GG"};

//        方式一：普通的for循环
//        for (int i = 0; i < strings.length; i++){
//            strings[i] = "MM";
//        }

//        方式二：增强for循环 \ foreach 重新赋值给s，并不改变原有数组元素
        for (String s :
             strings) {
            s = "MM";
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
