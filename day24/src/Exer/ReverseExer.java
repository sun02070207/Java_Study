package Exer;/*
@author Serenity
@create 2022-02-16-12:29
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseExer {
    /**
     * 请从键盘随机输入10个整数保存到List中，并按倒序、从大
     * 到小的顺序显示出来
     */
    @Test
    public void test(){
        Scanner scanner = new Scanner(System.in);
        ArrayList list = new ArrayList();
        System.out.println("请随机输入10个整数");
        for (int i = 0; i < 10; i++){
            System.out.println("请输入第" + (i + 1) + "个随机整数");
            try {
                int num = scanner.nextInt();
                list.add(num);
            }catch (ClassCastException e){
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }
}
