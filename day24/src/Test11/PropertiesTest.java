package Test11;/*
@author Serenity
@create 2022-02-15-21:18
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    //properties：常用来处理配置文件。key和value都是String类型
    public static void main(String[] args){
        FileInputStream file = null;
        try{
            Properties properties = new Properties();
            file = new FileInputStream("jdbc.properties");
            properties.load(file); //加载流对应文件
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println("name: " + name + ", password: " + password);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (file != null){
                try {
                    file.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
