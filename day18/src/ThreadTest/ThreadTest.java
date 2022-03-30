package ThreadTest;/*

    @description
    @author Serenity
    @create 2022-01-13-21:01


    多线程的创建：方式一：继承于Thread类
    1.创建一个继承于Thread类的子类
    2.重写Thread类的run() -->  将此线程执行的操作声明在run()中
    3.创建Thread类的子类的对象
    4.通过此对象调用start()方法

    例子：遍历100以内的所有的偶数
*/

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        Mythread mythread = new Mythread();
        //4.调用start()方法：①启动当前线程 ②调用当前线程的run()
        mythread.start();
        //问题一：我们不能通过直接调用run()的方式启动线程。
//        mythread.run();

        //问题二：再启动一个线程，遍历100以内的偶数.
        //问题二不可以还让已经start()的线程去执行。会报IllegalThreadStateException()
        //需要重新创建一个线程的对象才可以完成问题二。
//        mythread.start();
        Mythread mythread1 = new Mythread();
        mythread1.start();

        //如下操作仍是在main线程中执行的。
        for (int i = 0; i < 100; i++){
            if (i % 2 != 0){
//                System.out.println(i + "是奇数。");
                System.out.println(Thread.currentThread().getName() + i + "是奇数。");
            }
        }
    }
}
//1.创建一个继承于Thread类的子类
class Mythread extends Thread{
    //2.重写Thread类的run()

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
//                System.out.println(i + "是偶数。");
                System.out.println(Thread.currentThread().getName() + i + "是偶数。");
            }
        }
    }
}