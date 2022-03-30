package Test1;

import org.junit.Test;

import java.io.*;

public class ObjectinputStreamTest {

    @Test
    /*
    序列化过程：将内存中得java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    public void test(){
        //1.造文件造流
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //具体得序列化过程
            oos.writeObject(new String("好多卡好多钱"));
            oos.flush();//刷新操作
            oos.writeObject(new Person("Tom", 23));
            oos.flush();
            oos.writeObject(new Person("Jerry", 20, new Account(50000)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    /*
    反序列化使用ObjectinputStream实现
    将磁盘文件中得对象还原为内存中得一个java对象
     */
    public void test1(){
        ObjectInputStream ois = null;
        //1.造文件造流
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            //2.具体的反序列化过程
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
            Person p = (Person) ois.readObject();
            System.out.println(p);
            Person p1 = (Person) ois.readObject();
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
