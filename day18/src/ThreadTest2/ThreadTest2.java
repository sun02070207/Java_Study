package ThreadTest2;/*
    @description
    @author Serenity
    @create 2022-01-14-10:32

    创建多线程的方式二：实现Runnable接口
    1.创建一个实现了Runnable接口的类
    2.实现类去实现Runnable中的抽象方法：run()
    3.创建实现类的对象
    4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    5.通过Thread类的对象调用start()

    创建多线程方式一与方式二的对比：
    开发中：优先选择：实现Runnable接口的方式
    原因：1.实现的方式没有类的单继承性的局限性
         2.实现的方式更适合来处理多个线程有共享数据的情况。

    联系：class Thread implements Runnable
    相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
    程序：为了完成任务，用某种语言编写的一组指令的集合。即一段静态的代码。
    进程：正在运行的程序。是一个动态的过程，有生命周期。
    线程：一个程序内部运行的路径
*/


//import org.junit.Test;

import javax.sound.midi.Soundbank;
//1.创建一个实现了Runnable接口的类
class MyThreadTest2 implements Runnable{
//    2.实现类去实现Runnable中的抽象方法：run()
//    @Override
//    @Test
    //求质数
    public void run() {
        double num = 10.0;
        boolean isFlag = true;
        for (double i = 2; i <= num; i++){
            for (double j = 2; j <= Math.sqrt(i); j++){//计算2，3是否是质数时，其实第二个for没进来
                if (i % j == 0){
//                    System.out.println(i);
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(Thread.currentThread().getName()+ ":" +i);
            }
            isFlag = true;
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MyThreadTest2 myThreadTest2 = new MyThreadTest2();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(myThreadTest2);
        //5.通过Thread类的对象调用start():① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
        t1.setName("线程一");
        t1.start();

        //再启动一个线程，遍历10以内的质数
        Thread t2 = new Thread(myThreadTest2);
        t2.setName("线程二");
        t2.start();

    }
}
