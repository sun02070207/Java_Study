package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-17:01
*/

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {
    /*
    实现TCP的网络编程
    例题2：客户端发送文件给服务端，服务端将文件保存在本地
     */
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
//        ByteArrayOutputStream baos = null; //注意:图片文件请勿使用，否则可能出现无法读取的问题
        FileOutputStream fos = null;

        try {
            //1.创建服务器的ServerSocket，指明自己的端口号
            ss = new ServerSocket(65530);
            //2.调用accept()获取客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.读取输入流中的数据
            fos = new FileOutputStream(new File("1024.JPG"));
//            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            System.out.println("读取数据完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
//            if (baos != null){
//                try {
//                    baos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
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
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        try {
            //1.创建Socket对象，指明服务器端的IP和端口号
            socket = new Socket(InetAddress.getLocalHost(), 65530);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            fis = new FileInputStream(new File("1024节.JPG"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
