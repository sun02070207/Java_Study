package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-15:45
*/

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    /*
    网络编程（通信）：
    要素1：IP和端口号
     */
    @Test
    public void test(){
        try {
            InetAddress byName = InetAddress.getByName("192.168.10.12");
            System.out.println(byName); ///192.168.10.12

            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName1); //www.baidu.com/180.101.49.11

            //获取本地IP
            InetAddress byName2 = InetAddress.getByName("127.0.0.1");
            System.out.println(byName2); ///127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost); //DESKTOP-UV7FU1P/10.14.51.136

            //getHostName()
            System.out.println(byName1.getHostName()); //www.baidu.com
            //getHostAddress()
            System.out.println(byName1.getHostAddress()); //180.101.49.11


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
