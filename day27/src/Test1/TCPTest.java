package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-16:18
*/

import jdk.nashorn.internal.objects.NativeUint8Array;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPTest {
    @Test
    public void test(){
        /*
        实现TCP的网络编程
        例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
         */
        //客户端
        OutputStream os = null;
        Socket soc = null;


        try {
            //1.创建Socket对象，指明服务器端的IP和端口号
            InetAddress ia = InetAddress.getByName("127.0.0.1");

            soc = new Socket(ia, 65533);
            //2.获取一个输出流，用于输出数据
            os = soc.getOutputStream();
            //3.写出数据的操作
            os.write("你好，我是客户端heiheihei".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (soc != null){
                try {
                    soc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test1(){
        //服务器端
        ServerSocket serverSocket = null;
        InputStream is = null;
        Socket socket = null;
        ByteArrayOutputStream bos = null;
        try {
            //1.创建服务器的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(65533);
            //2.调用accept()表示接收来自于客户端的socket
            socket = serverSocket.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //如下写法可能会出现乱码
//            byte[] buffer = new byte[5];
//            int len;
//            while((len = is.read(buffer)) != -1){
//                String str = new String(buffer, 0, len);
//                System.out.println(str);
//            }

            //4.读取输入流中的数据
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len; //记录读入到数组中的元素个数
            while((len = is.read(bytes)) != -1){
                bos.write(bytes, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (bos != null){
                try {
                    bos.close();
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
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
