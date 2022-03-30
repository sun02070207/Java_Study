package Test1;/*
    @description
    @author Serenity
    @create 2022-02-24-14:56
*/

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test(){
        /*
        了解类的加载器
         */
     //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = Person.class.getClassLoader();
        ClassLoader classLoader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader1); //sun.misc.Launcher$AppClassLoader@18b4aac2
        //调用系统类加载的getParent():获取扩展类加载器
        ClassLoader classLoader2 = classLoader.getParent();
        System.out.println(classLoader2); //sun.misc.Launcher$ExtClassLoader@1f32e575
        //调用扩展类加载器的getParent():无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3); //null
        //String的加载器就是引导类加载器
        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader4); //null
    }

    @Test
    public void test1(){
        Properties properties = new Properties();
        FileInputStream fis = null;
        InputStream is = null;
        //此时的文件默认在当前的module下
        try {
            //读取配置文件的方式一：
//            fis = new FileInputStream("jdbc.properties");
//            fis = new FileInputStream("src\\jdbc1.properties");
//            properties.load(fis);

            //读取配置文件的方式二：使用ClassLoader
            //配置文件默认识别为：当前module的src下
            ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
            is = classLoader.getResourceAsStream("jdbc1.properties");
            properties.load(is);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println("user：" + user + ", password：" + password);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
