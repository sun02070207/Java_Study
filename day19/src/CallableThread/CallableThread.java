package CallableThread;/*
    @description
    @author Serenity
    @create 2022-01-15-15:06

    创建线程的方式三：实现Callable接口。 --JDK 5.0新增
    1.创建一个实现Callable的实现类
    2.实现call方法，将此线程需要执行的操作声明在call中
    3.创建Callable接口实现类的对象
    4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
    5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用strat();
    6.如果对call方法返回值感兴趣的话，可以获取Callable中的call方法返回值

    如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
    1.call()可以有返回值
    2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
    3.Callable是支持泛型的
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//1.创建一个实现Callable的实现类
class NumberThread implements Callable{
    @Override
//    2.实现call方法，将此线程需要执行的操作声明在call中
    public Object call() throws Exception {
        int num = 0;
        boolean isFlag = true;
        for (int i = 2; i <= 100; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                num += i;
                System.out.println(i);
            }
            isFlag = true;
        }
        return num;
    }
}
public class CallableThread {
    public static void main(String[] args){
//        3.创建Callable接口实现类的对象
        NumberThread n1 = new NumberThread();
//        4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask f1 = new FutureTask(n1);
//        5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用strat();
        new Thread(f1).start();
//        6.如果对call方法返回值感兴趣的话，可以获取Callable中的call方法返回值
        try {
            Object num = f1.get();
            System.out.println("100以内的质数总和" + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
