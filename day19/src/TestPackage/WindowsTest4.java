package TestPackage;/*
    @description
    @author Serenity
    @create 2022-01-14-21:21
*/
class Windowss extends Thread{
    private static int ticket = 1; //加入static，每个对象共享一个静态变量
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
//                synchronized(obj){ //非实现的方式使用synchronized(this)是错误的方式：this代表着w1,w2,w3三个对象
             //Class clazz = Windows.class,Windows.class只加载了一次

//            }
            show();
        }
    }
public static synchronized void show(){//同步监视器：Windowss.class
//    public synchronized void show(){ //同步监视器：t1,t2,t3
        if (ticket <= 100){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket++;
        }
    }
}

public class WindowsTest4 {
    public static void main(String[] args){
        Windowss w1 = new Windowss();
        Windowss w2 = new Windowss();
        Windowss w3 = new Windowss();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
