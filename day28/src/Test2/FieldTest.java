package Test2;/*
    @description
    @author Serenity
    @create 2022-02-24-16:26
*/

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Test2.Person");

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for (Field f : fields){
            System.out.println(f);
        }

        System.out.println("********************");
        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field f : fields1){
            System.out.println(f);
        }
        System.out.println("********************");
    }

    //权限修饰符 数据类型 变量名
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Test2.Person");
        Field[] fields = aClass.getDeclaredFields();
        for (Field f : fields){
            //权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            //变量名
            String name = f.getName();
            System.out.println(name);
        }
    }
}
