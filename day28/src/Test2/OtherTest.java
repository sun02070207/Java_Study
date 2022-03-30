package Test2;/*
    @description
    @author Serenity
    @create 2022-02-24-19:25
*/

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    /*
    获取构造器结构
     */
    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Test2.Person");
        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        System.out.println("**********************");
        //getDeclaredConstructors()：获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }
    //获取构造器的权限修饰符，构造器名称和形参列表的方法与获取方法的一致
    @Test
    public void test2(){
        /*
        获取运行时类的父类
         */
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    public void test3(){
        /*
        获取运行时类的带泛型的父类
         */
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void test4(){
        /*
        获取运行时类的带泛型的父类的泛型
         */
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        //两种输出方法
//        System.out.println(actualTypeArguments[0].getTypeName()); //由于只有一个泛型参数直接写了角标
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    @Test
    public void test5(){
        /*
        获取运行时类的接口
         */
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class c : interfaces1){
            System.out.println(c);
        }
    }

    @Test
    public void test6(){
        /*
        获取运行时类的所在包
         */
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void test7(){
        /*
        获取运行时类声明的注解
         */
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
        }
    }

}
