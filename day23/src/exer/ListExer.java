package exer;/*
@author Serenity
@create 2022-02-14-12:22
*/


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListExer {
    /**
     * 区分remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
//        list.remove(2); //[1, 2]
        list.remove(new Integer(2));  //[1, 3]
    }
}
