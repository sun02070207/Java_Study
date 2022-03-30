package Test1;/*
@author Serenity
@create 2022-02-11-12:06
*/

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的使用
 *
 * 1.理解Annotation：
 * ① jdk 5.0新功能
 *
 * ② Anntation其实就是代码里的特殊标记, 这些标记可以在编译, 类加
 * 载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *
 * ③ 在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 *
 * 2.Annotation的常见示例：
 *
 * 示例一：生成文档的相关注解
 *
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *@Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
 * 所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 *
 * 示例三：跟踪代码依赖性，实现替代文件配置功能。
 *
 * 3.如何自定义注解
 *  参照SuperWarnings定义
 *  ① 注解声明为：@interface
 *  ② 内部定义成员通常使用value表示
 *  ③ 可以指定成员的默认值，使用default定义
 *  ④ 如果自定义注解没有成员，表明是一个标识作用
 *
 *  如果注解有成员，在使用注解时，需要指明成员的值。
 *  自定义注解必须配上注解的信息处理流程（使用反射）才有意义。
 *  自定义注解通常都会指明两个元注解：Retention、Target
 *
 *  4.jdk提供的4中元注解
 *   元注解：对现有的注解进行解释说明的注解
 *   JDK5.0提供了4个标准的meta-annotation类型，分别是：
 * Retention：指定所修飾的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *             只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 * Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 * *************低频出现*************
 * Documented：表示所修饰的注解在被javadoc解析时，保留下来
 * Inherited：被修饰的Annotation将具有继承性。
 *
 * 5.通过反射获取注解信息----->具体内容在反射章节
 *
 * 6.jdk8.0之后的注解新特性
 * 6.1可重复注解
 *  ① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *  ② MyAnnontation的@Target和@Retention必须和MyAnnotaitons一样。
 *6.2类型注解
 * ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 * ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 */
public class AnnotationTest {
    public static void main(String[] args){
        Student s1 = new Student();
        s1.eat();
//        @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
//         所修饰的结构危险或存在更好的选择
        @Deprecated
        @SuppressWarnings("unused")
        Date date = new Date(2022, 2, 11);


    }
    @Test
    public void getAnnotation(){
        Class studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for(int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i]);
        }
    }


}
//jdk 8.0之前的写法
//@MyAnnotations({@MyAnnotation("v1"), @MyAnnotation("v2")})

//jdk8.0之后的写法
@MyAnnotation("v")
@MyAnnotation("value1")
class Person{
    private String name;
    private int age;
    @MyAnnotation()
    public Person(){

    }
    @SuppressWarnings("unused")
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }
    @SuppressWarnings("unused")
    public int getAge() {
        return age;
    }
    @SuppressWarnings("unused")
    public void setAge(int age) {
        this.age = age;
    }
    @SuppressWarnings("unused")
    public void eat(){
        System.out.println("吃饭了");
    }
}
interface Info1{
    @SuppressWarnings("unused")
    void show();
}

class Student extends Person implements Info1{
    //@Override: 限定重写父类方法, 该注解只能用于方法
    @Override
    public void show() {
        System.out.println("秀你们一脸");
    }
    @Override
    public void eat(){
        System.out.println("吃得好不如学的好");
    }
}
class Generic<@MyAnnotation T>{
    public void show(){
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int i = (@MyAnnotation int) 10L;
    }
}