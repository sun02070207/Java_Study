package Test1;/*
@author Serenity
@create 2022-02-18-22:43
*/

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    /*

     */
    @Test
    public void test(){
        InputStreamReader isr = null;

        try {
            FileInputStream fis = new FileInputStream("dbcp.txt");
            //        isr = new InputStreamReader(new FilterInputStream("dbcp.txt")); //使用默认字符集
            //参数2指明字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
            isr = new InputStreamReader(fis, "UTF-8"); //使用UTF-8字符集
            char[] cbuf = new char[5];
            int len; //记录读取到cbuf数组的数据个数
            while((len = isr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1(){
        /*
        综合InputStreamReader和OutputWriter的使用
         */
        //指定文件
        File file = new File("dbcp.txt");
        File file1 = new File("GBK编码的dbcp.txt");
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //指定流
            isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream(file1), "GBK");

            //读写操作
            char[] cbuf = new char[10];
            int len; //记录读取数据到数组的个数
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
