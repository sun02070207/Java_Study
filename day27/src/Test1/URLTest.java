package Test1;/*
    @description
    @author Serenity
    @create 2022-02-23-20:22
*/

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void test(){
        URL url = null;
        try {
            url = new URL("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=3&spn=0&di=7042744173476184065&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2400619865%2C2131754380&os=3609255376%2C3395504451&simid=2400619865%2C2131754380&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%3A%2F%2Fdesk-fd.zol-img.com.cn%2Ft_s960x600c5%2Fg2%2FM00%2F00%2F0B%2FChMlWl6yKqyILFoCACn-5rom2uIAAO4DgEODxAAKf7-298.jpg%26refer%3Dhttp%3A%2F%2Fdesk-fd.zol-img.com.cn%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1648212001%26t%3Da14179577002912b98f211d9f9b15bae&fromurl=ippr_z2C%24qAzdH3FAzdH3F1jfh_z%26e3Bz5s_z%26e3Bv54_z%26e3BvgAzdH3FktzitAzdH3Fblb8_88adnm_9_z%26e3Bip4s&gsm=1&islist=&querylist=&dyTabStr=MCwzLDEsNiwyLDQsNSw3LDgsOQ%3D%3D");
//        public String getProtocol( ) 获取该URL的协议名
            System.out.println(url.getProtocol()); //http
//        public String getHost( ) 获取该URL的主机名
            System.out.println(url.getHost()); //192.168.1.100
//        public String getPort( ) 获取该URL的端口号
            System.out.println(url.getPort()); //8080
//        public String getPath( ) 获取该URL的文件路径
            System.out.println(url.getPath()); ///helloworld/index.jsp
//        public String getFile( ) 获取该URL的文件名
            System.out.println(url.getFile()); ///helloworld/index.jsp
//        public String getQuery( ) 获取该URL的查询名
            System.out.println(url.getQuery()); //null
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
