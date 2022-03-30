package Test2;/*
    @description
    @author Serenity
    @create 2022-02-24-20:09
*/

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p = (Person) personClass.newInstance();
        //获取指定的属性：要求运行时类中属性声明为public
        //通常不用此方法
        Field id = personClass.getField("id");
        /*
        设置当前属性的值

        set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
         */
        id.set(p, 1001);
        /*
        获取当前属性的值
        get()：参数1：获取哪个对象的当前属性值
         */
        int i = (int) id.get(p);
        System.out.println(i);
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        /*
        如何操作运行时类中的指定属性——————需要掌握
         */
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p = personClass.newInstance();
        //获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");
        //保证当前属性时可访问的
        name.setAccessible(true);
        //获取、设置指定对象的此属性值
        name.set(p, "Jerry");
        System.out.println(name.get(p));

    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /*
        如何操作运行类中的指定的方法：--需要掌握
         */

        //1.创建.class
        Class<Person> personClass = Person.class;
        //2.创建运行时类的对象
        Person p = personClass.newInstance();
        /*
        3.获取指定的某个方法
        ：参数1：指明获取的方法的名称 参数2：指明湖区的方法的形参列表
         */
        Method getNation = personClass.getDeclaredMethod("getNation", String.class);
        //4.保证当前方法是可访问的
        getNation.setAccessible(true);

        /*
        5.调用方法的invoke():参数1：方法的调用者    参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object invoke = getNation.invoke(p, "CHINA");
        System.out.println(invoke);

        System.out.println("***********如何调用静态方法***************");

//        private static void showDesc()
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
//        Object invoke1 = showDesc.invoke(null);
        Object invoke1 = showDesc.invoke(Person.class);
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        System.out.println(invoke1); // null

    }

    @Test
    public void test3() throws Exception {
        /*
        如何操作运行类中的指定的构造器：--通常只有针对具体某个问题指定构造器，否则使用newInstance()
         */
        Class<Person> personClass = Person.class;
        /*
        1.获取指定的构造器getDeclaredConstructor()：参数：指明构造器的参数列表
         */
        // private Person(String name)
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person p = (Person) constructor.newInstance("Jerry");
        System.out.println(p); //Person{name='Jerry', age=0, id=0}

    }
}
