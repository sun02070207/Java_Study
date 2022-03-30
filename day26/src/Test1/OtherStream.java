package Test1;/*
@author Serenity
@create 2022-02-21-16:07
*/

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Test;

import java.io.*;
import java.util.Locale;

public class OtherStream {
    public static void main(String[] args){
//    public void test(){
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true){
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }else {
                    String s = data.toUpperCase();
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test1(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
// 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                } }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            } }
    }

    @Test
    public void test2(){
        /*
        数据流写入操作
         */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("textdata.txt"));
            dos.writeUTF("韩可欣");
            dos.flush();//刷新操作，将内存中的数据写入文件
            dos.writeInt(3);
            dos.flush();//刷新操作，将内存中的数据写入文件
            dos.writeUTF("从小爱臭美");
            dos.flush();//刷新操作，将内存中的数据写入文件
            dos.writeBoolean(true);
            dos.flush();//刷新操作，将内存中的数据写入文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        /*
        数据流读取操作
         */
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("textdata.txt"));
            String name = dis.readUTF();
            int age = dis.readInt();
            String like = dis.readUTF();
            boolean isgirl = dis.readBoolean();

            System.out.println("名字：" + name + ", 年龄：" + age + ", 爱好：" + like + ", 性别：" + isgirl);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
