package Test1;/*
    @description
    @author Serenity
    @create 2022-02-24-10:29
*/

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RefliectionTest {
    @Test
    public void test(){
        /*
        反射之前的操作
         */
        //1.创建Person类的对象
        Person p1 = new Person("Jerry", 18);
        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name 、showNation()以及私有的构造器

    }

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        /*
        反射之后，对于Person的操作
         */
        Class personClass = Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = personClass.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Jerry", 18);
        Person p = (Person) obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p, 22);
        System.out.println(p.toString());

        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Milk");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);

        //调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "嘿嘿");
        System.out.println(p1);

    }

    //疑问？
    //1.通过直接new的方式或反射的方式都可以调用公开的结构，开发中到底用哪个？
    //答：建议直接new的方式
    //什么时候会使用反射的方式：反射的特征：动态性。
    //反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。之所以封装，是在指明什么构造器、属性、方法可以直接调用，其他私有的均是不必调用，或者重写过了。单例设计模式将构造器私有化，就暗示说明直接使用即可。

    @Test
    public void test2() throws ClassNotFoundException {
        /*
        获取Class的实例方式
         */
        //方式一：调用运行时类的属性.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class<? extends Person> aClass = p1.getClass();
        System.out.println(aClass);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> aClass1 = Class.forName("Test1.Person");
        System.out.println(aClass1);

        System.out.println(personClass == aClass); //true
        System.out.println(personClass == aClass1); //true 说明都指向同一地址的Person

        //方式四：使用类的加载器：ClassLoader(了解)
        ClassLoader classLoader = RefliectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("Test1.Person");
        System.out.println(aClass2);
        System.out.println(personClass == aClass2);

        int[] a= new int[10];
        int[] b= new int[100];
        Class c10= a.getClass();
        Class c11= b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10== c11);

        Class c1= Object.class;
        Class c2= Comparable.class;Class c3= String[].class;
        Class c4= int[][].class;
        Class c5= ElementType.class;Class c6= Override.class;
        Class c7= int.class;
        Class c8= void.class;
        Class c9= Class.class;
    }

}
