package TestPackage;/*
    @description
    @author Serenity
    @create 2022-01-14-10:19
    例子：创建三个窗口卖票，总票数100张。

    使用同步代码块解决继承Thread类的方式的线程安全问题

    说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器(this创建必须唯一)，考虑使用当前类充当同步监视器

*/
class Windows extends Thread{
    private static int ticket = 1; //加入static，每个对象共享一个静态变量
    private static Object obj = new Object();
    @Override
    public void run() {
            while (true){
//                synchronized(obj){ //非实现的方式使用synchronized(this)是错误的方式：this代表着w1,w2,w3三个对象
                synchronized (Windows.class){ //Class clazz = Windows.class,Windows.class只加载了一次
                    if (ticket <= 100){
                        System.out.println(getName() + ": 卖票，票号为：" + ticket);
                        ticket++;
                    }else {
                        break;
                    }
                }
            }
        }
}

public class WindowsTest2 {
    public static void main(String[] args){
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
