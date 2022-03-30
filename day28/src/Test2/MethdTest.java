package Test2;/*
    @description
    @author Serenity
    @create 2022-02-24-16:44
*/

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethdTest {
    @Test
    public void test() throws ClassNotFoundException {
        /*
        获取运行时类的方法结构
         */

        Class<?> aClass = Class.forName("Test2.Person");
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = aClass.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("************");
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }
    @Test
    public void test1() throws ClassNotFoundException {
        /*
        @方法声明的注解
        权限修饰符   返回值类型   方法名（参数类型1 形参1，...） throws XxxException{}
         */
        Class<?> aClass = Class.forName("Test2.Person");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.print(a);
            }

            //2.获取权限修饰符
            int modifiers = m.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //3.获取返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.print(returnType.getName() + "\t");

            //4.获取方法名
            String name = m.getName();
            System.out.print(name + "\t");

            //5.获取参数类型
            Class[] parameterTypes = m.getParameterTypes();
            System.out.print("(");
            if (!(parameterTypes == null && parameterTypes.length == 0)){
//                for (Class c : parameterTypes){
//                    System.out.println("参数类型" + c);
//                }
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes.length - 1 == i){
                        System.out.print(parameterTypes[i].getName() + "args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }
            System.out.println(")");

            //6.抛出的异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
//            if (!(exceptionTypes == null && exceptionTypes.length == 0)){
//                for (int i = 0; i < exceptionTypes.length; i++){
//                    if (i == exceptionTypes.length - 1){
//                        System.out.print(exceptionTypes[i].getName());
//                        break;
//                    }
//                    System.out.print(exceptionTypes[i].getName() + ",");
//                }
//            }
            if (exceptionTypes.length > 0){
                System.out.print("throws");
                for (int i = 0; i < exceptionTypes.length; i++){
                    if (i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

        }
    }

}
