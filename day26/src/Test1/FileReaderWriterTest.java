package Test1;/*
@author Serenity
@create 2022-02-17-22:58
*/

import org.junit.Test;

import java.io.*;

/*
一、流的分类
1.操作数据单位：字节流，字符流
2.数据的流向：输入流，输出流
3.流的角色：节点流，处理流

二、流的体系结构
抽象基类        节点流(文件流)            缓冲流(处理流的一种)
InputStream    FileInputStream         BufferedInputStream
OutStream      FileOutStream           BufferedOutStream
Reader         FileReader              BufferedReader
Writer         FileWriter              BufferedWriter


 */
public class FileReaderWriterTest {
    /*
    使用main实例化的File类对象的相对地址是在当前工程下
    使用@Test方法实例化的File类对象的相对地址是在当前module下
     */
    @Test
    public void test(){
        /*
        将day26module下的hello.txt文件内容读入程序中，并输出到控制台

        说明：
        1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1.
        2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
        3.读入文件一定要存在，否则就会报FileNotFoundException。
         */
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            //2.提供具体的流
            fileReader = new FileReader(file);
            //3.数据读入
            int data;
            while ((data = fileReader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.流关闭操作
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //对read()操作的升级：使用read()的重载方法
    @Test
    public void test1() throws FileNotFoundException {
        //1.File类的实例化，指明需要读入的文件
        File file = new File("hello.txt");
        //2.FileReader流的实例化，提供具体的流
        FileReader fileReader = new FileReader(file);
        try{
           //3.利用流调用read()方法，读数据
           //read(char[] cbuffer)：返回每次读入cbuffer数组中的字符的个数。如果达到文件末尾，返回-1.
           char[] cbuffer = new char[6];
           int len; //记录每次读入到cbuffer数组中的字符的个数
           while ((len = fileReader.read(cbuffer)) != -1){
               //方式一
               //错误写法
//               for (int i = 0; i < cbuffer.length; i++){
//                   System.out.print(cbuffer[i]);
//               }
               //正确写法
//                for (int i = 0; i < len; i++){
//                    System.out.print(cbuffer[i]);
//                }

                //方式二
               //错误的写法，对应着方式一的错误写法
//               String str = new String(cbuffer);
//               System.out.print(str);
               //正确的写法
               String str = new String(cbuffer, 0, len);
               System.out.print(str);
           }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
            //4.关闭流操作
           if (fileReader != null){
               try {
                   fileReader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    /*
    从内存中写出数据到硬盘的文件里

    说明：
    1.输出操作，对应的File可以不存在，并不会报异常
    2.
        File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
        File对应的硬盘中的文件如果存在：
            如果流使用的构造器是：FileWriter(file, false) / FileWriter(file)则对原有文件进行覆盖。
            如果流使用的构造器是：FileWriter(file, true) 则不会对原有文件进行覆盖，而是在原有文件基础上最佳内容。
     */
    @Test
    public void test2(){
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的操作
            fw.write("加油学习啊，加快进度努力啊！\n");
            fw.write("加油学习啊，加快进度努力啊！\n");
            fw.write("恭喜发财！\n");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //4.流的关闭
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读进来，写出去操作，实际就是复制
    @Test
    public void test3() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.1创建File类的对象，指明读出数据的文件
            File file = new File("hello1.txt");
            //1.2创建File类的对象，指明写入数据的文件
            File file1 = new File("hello2.txt");
            //2.1创建FileReader()输入流的实例化
            fileReader = new FileReader(file);
            //2.2创建FileWriter()输出流的实例化
            fileWriter = new FileWriter(file1);
            //3.数据的读出与写入
            char[] cbuffer = new char[6]; //读出数据的字符数组
            int len; //记录每次读出到cbuffer的字符的个数
            while ((len = fileReader.read(cbuffer)) != -1){
                //每次写出len个字符
                fileWriter.write(cbuffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.输入流与输出流的关闭，谁先谁后都可
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
