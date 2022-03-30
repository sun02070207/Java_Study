package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-18:31
*/

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    /*
    实现TCP的网络编程
    例题3：从客户端发送文件给服务器，服务端保存到本地。并返回”发送成功“给客户端。
    并关闭相应连接
     */
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;


        try {
            //1.创建ServerSocket对象，并指明服务器的端口号
            ss = new ServerSocket(65535);
            //2.使用accept()方法获得客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.获取输入流的数据
            fos = new FileOutputStream(new File("1024的案例3.JPG"));
            byte[] buffer = new byte[1024];
            int len; //记录读取到数组的数据内容数
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //5.服务器端给予客户端反馈
//            System.out.println("heihei");
            os = socket.getOutputStream();
            os.write("图片已收到！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if (os != null){
                try {
                    os.close();
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
        }
    }
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try {
            //1.创建Socket对象，指明服务器的端口号和ID
            socket = new Socket(InetAddress.getLocalHost(), 65535);
            //2.创建一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            fis = new FileInputStream(new File("1024节.JPG"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            //4.关闭数据的输出
            socket.shutdownOutput();
            //5.接受来自服务器的数据，并输出在控制台上
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[20];
            int len1;
            while ((len1 = is.read(bytes)) != -1){
                baos.write(bytes, 0, len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if (baos != null){
                try {
                    baos.close();
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
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
        }
    }
}
