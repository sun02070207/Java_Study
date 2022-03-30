package Exer;/*
@author Serenity
@create 2022-02-18-22:10
*/

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class PicTest {
    /*
    图片的加密
     */
    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("1024节.JPG");
            fos = new FileOutputStream("加密1024节.JPG");

            byte[] b = new byte[10];
            int len; //记录读取的b的字节的个数
            while ((len = fis.read(b)) != -1){
                //字节数组进行修改
                //错误的
//                for(byte b1 : b){
//                    b1 = (byte) (b1 ^ 5);//注意赋值对象，原b并没有进行加密修改
//                }
                for (int i = 0; i < len; i++){
                    b[i] = (byte) (b[i] ^ 5);
                }
                fos.write(b,0,len);
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

    /*
    图片的解密：使用异或加密的文件可以通过再次异或解密。
     */
    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("加密1024节.JPG");
            fos = new FileOutputStream("解密1024节.JPG");

            byte[] b = new byte[10];
            int len; //记录读取的b的字节的个数
            while ((len = fis.read(b)) != -1){
                //字节数组进行修改
                //错误的
//                for(byte b1 : b){
//                    b1 = (byte) (b1 ^ 5);//注意赋值对象，原b并没有进行加密修改
//                }
                for (int i = 0; i < len; i++){
                    b[i] = (byte) (b[i] ^ 5);
                }
                fos.write(b,0,len);
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

}
