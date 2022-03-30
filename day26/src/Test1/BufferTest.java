package Test1;/*
@author Serenity
@create 2022-02-18-20:18
*/

import org.junit.Test;

import java.io.*;

/*
处理流之一：缓冲流的使用
1.缓冲流：
    BufferedInputStream
    BufferedOutStream
    BufferedReader
    BufferedWriter

2.作用：提高流的读取、写入速度

3.处理流，就是“套接”在已有的流的基础上

 */
public class BufferTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //通过实例化File，指定文件
            File file = new File("1024节.JPG");
            File file1 = new File("1024节(2).JPG");
            //确定输入输出流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //确定处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制功能
            byte[] b = new byte[5];
            int len; //记录每次读入b数组中的字节个数
            while((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要求：先关闭外层的流，再关闭内层的流
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
        }

    }

    public void copyBufferedFile(String srcFile, String destFile){
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //确定文件
            File file = new File(srcFile);
            File file1 = new File(destFile);
            //指定流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //复制操作
            byte[] b = new byte[1024];
            int len; //记录读出的字节个数
            while ((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void testCopy(){
        //测试复制方法copyFile
        long start = System.currentTimeMillis();
        String srcFile = "D:\\QLDownload\\特工008\\特工008 720P(准高清).qlv";
        String destFile = "D:\\QLDownload\\特工008\\特工006 720P(准高清).qlv";

        copyBufferedFile(srcFile, destFile);
        long end = System.currentTimeMillis();
        System.out.println("复制使用时间：" + (end - start)); //3645  //带上处理流使用了851毫秒
    }
    /*
    使用BufferedReader和BufferedWriter实现文本文件复制
     */
        @Test
        public void test1(){
            BufferedReader br = null;
            BufferedWriter bw = null;
            try {
                //指明流与文件
                br = new BufferedReader(new FileReader(new File("dbcp.txt")));
                bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

                //复制过程
                char[] cbuf = new char[5];
                int len; //记录加入数组cbuf中的字符个数
                //方式一
    //            while ((len = br.read(cbuf)) != -1){
    //                bw.write(cbuf, 0, len);
    //            }
                //方式二:使用String
                String data;
                while ((data = br.readLine()) != null){
                    //换行的方法1：\n换行符
    //                bw.write(data + "\n"); //data中不包含换行符
                    //换行的方法2：加nextLine()方法
                    bw.write(data);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //
                if (br != null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
