package TestPackage3;/*
    @description
    @author Serenity
    @create 2022-01-15-9:47

    解决线程安全问题的方式三：Lock锁 --JDK5.0新增

    1.面试题：synchronized 与 lock的异同？
    相同：二者都可以解决线程安全问题
    不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
        Lock需要手动的启动同步（Lock()），同时结束同步也需要手动的实现（unlock()）
*/

import java.util.concurrent.locks.ReentrantLock;

class Window implements Runnable{
    private int ticket = 1;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (;;){
            try {
                //2,调用锁定方法lock()
                lock.lock();
                if (ticket <= 100){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为" + ticket);
                    ticket++;
                }else {
                    break;
                }
            }finally {
                //调用解锁的方法unlock()
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
