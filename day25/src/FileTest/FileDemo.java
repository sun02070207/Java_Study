package FileTest;/*
@author Serenity
@create 2022-02-17-19:30
*/

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    /*
    利用File构造器，new 一个文件目录file
    1)在其中创建多个文件和目录
    2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test(){
        File file = new File("Exer");
        if (!file.exists()){
            file.mkdirs();
            File destFile = new File(file.getAbsoluteFile(), "Test");
            if (destFile.mkdir()){
                System.out.println("创建成功");
            }
        }else {
            file.delete(); //有Bug，如果Exer存在且文件目录中有内容，则无法删除
        }
    }
    @Test
    public void test1(){
        /*
        判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
         */
        File file = new File("haha.jpg");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File("F:\\javacode\\IDEAJava\\JavaSenior\\day25");
        String[] list = file1.list();
        for (String s:
             list) {
            if (s.endsWith(".jpg")){
                System.out.println(s);
            }
        }

    }
    /*
    遍历指定目录所有文件名称，包括子文件目录中的文件。
    拓展1：并计算指定目录占用空间的大小
    拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test2(){
        File file = new File("G:\\Java学习课件\\尚硅谷Java学科全套教程（总207.77GB）\\1.尚硅谷全套JAVA教程--基础必备（67.32GB）\\尚硅谷宋红康Java核心基础(30天入门）\\课件笔记源码资料\\新建文件夹\\1_课件\\第2部分：Java高级编程\\第2部分：Java高级编程\\尚硅谷_宋红康_第13章_IO流");

        printFile(file);
    }

    public static void printFile(File dir){
        File[] files = dir.listFiles();

        for (File f : files){
            if (f.isFile()){
                System.out.println(f.getAbsoluteFile());
            }else {
                printFile(f);
            }
        }

    }
}
