package WindowsTest;/*
    @description
    @author Serenity
    @create 2022-01-14-14:25

    例子:创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
    依然存在线程安全问题，待解决
*/

import java.util.PrimitiveIterator;

class MyWindows implements Runnable{
    private int tickets = 0;
    @Override
    public void run() {
        for (;;){
            if (tickets <= 100){
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + tickets);
                tickets++;
            }else {
                break;
            }

        }
    }
}
public class WindowsTest1 {
    public static void main(String[] args) {
        MyWindows myWindows = new MyWindows();
        Thread t1 = new Thread(myWindows);//三个线程都是同一个myWindows对象，故共100张
        Thread t2 = new Thread(myWindows);
        Thread t3 = new Thread(myWindows);
        t1.setName("窗口1");
        t1.start();
        t2.setName("窗口2");
        t2.start();
        t3.setName("窗口3");
        t3.start();
    }
}
