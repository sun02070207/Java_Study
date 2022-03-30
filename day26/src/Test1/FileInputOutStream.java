package Test1;/*
@author Serenity
@create 2022-02-18-18:39
*/

import org.junit.Test;

import java.io.*;

/*
测试FileInputStream和FileOutStream的使用
注意点：
    1.对于文本文件(.txt \ .java \ .c \ .cpp)，使用字符流处理
    2.对于非文本文件(.jpg \ .mp3 \ .mp4 \ .avi \ .doc \ .ppt...)，使用字节流处理
 */
public class FileInputOutStream {
    //使用字节流FileInputStream处理文本文件是可能出现乱码的，例如：在使用汉字时
    @Test
    public void test(){
        FileInputStream fInputStream = null;
        try {
            //1.实例化File，指定读入文件
            File file = new File("hello3.txt");
            //2.实例化FileInputStream流
            fInputStream = new FileInputStream(file);
            //3.读入操作
            byte[] b = new byte[5];
            int len; //记录每次读到b数组中的字节个数
            while ((len = fInputStream.read(b)) != -1){
//                for (int i = 0; i < len; i++){
//                    System.out.print(b[i]);
//                }
                String str = new String(b,0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流关闭操作
            try {
                fInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对.jpg文件的复制
    @Test
    public void test1() throws FileNotFoundException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.实例化File,指定文件
            File file = new File("1024节.JPG");
            File file1 = new File("1024节(1).JPG");
            //2.实例化FileInputStream,提供具体的操作流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //3.实现对图片的复制
            byte[] b = new byte[5]; //创建存储字节的数组
            int len; //记录每个读出数据的字节的个数
            while ((len = fis.read(b)) != -1){
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //指定路径下的文件复制方法
    public void copyFile(String srcFile, String destFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //确定文件
            File file = new File(srcFile);
            File file1 = new File(destFile);
            //指定流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //复制操作
            byte[] b = new byte[1024];
            int len; //记录读出的字节个数
            while ((len = fis.read(b)) != -1){
                fos.write(b, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
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
        String destFile = "D:\\QLDownload\\特工008\\特工007 720P(准高清).qlv";

        copyFile(srcFile, destFile);
        long end = System.currentTimeMillis();
        System.out.println("复制使用时间：" + (end - start)); //3645
    }
}
