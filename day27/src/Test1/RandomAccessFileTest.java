package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-11:12
*/

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileTest {
    //随机存储文件流的读出和写入操作
    @Test
    public void test(){
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            //1.造文件类+造流类
            raf = new RandomAccessFile(new File("1024节.JPG"), "r");
            raf1 = new RandomAccessFile(new File("随机存储文件流.JPG"), "rw");
            //2.复制文件操作
            byte[] bytes = new byte[1024];
            int len; //记录读取到字节数组的数据个数
            while ((len = raf.read(bytes)) != -1){
                raf1.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1(){
        RandomAccessFile rafw = null;
        //覆盖文件内容的操作
        try {
            rafw = new RandomAccessFile(new File("字母.txt"), "rw");
            rafw.seek(3); //将指针调到角标为3的位置
            rafw.write("xyz".getBytes());//覆盖了文件开头的abc,从abcdefghijklmnopqrstuvw变为xyzdefghijklmnopqrstuvw
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rafw != null){
                try {
                    rafw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        /*
        使用RandomAccessFile实现数据的插入操作
         */
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile(new File("字母.txt"), "rw");
            raf1.seek(3); //将指针调到角标为3的位置
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) new File("字母.txt").length());
            byte[] buffer = new byte[10];
            int len;
            while ((len = raf1.read(buffer)) != -1){
                builder.append(new String(buffer, 0, len));
            }
            //保存完数据之后，再调回到指针3的地方，写入xyz覆盖原数据
            raf1.seek(3);
            raf1.write("xyz".getBytes());

            //将StringBuilder中的数据写入到文件中
            raf1.write(builder.toString().getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //思考：将StringBuilder替换为ByteArrayOutputStream

    }
}
