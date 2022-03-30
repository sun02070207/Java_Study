package TestPackage;/*
    @description
    @author Serenity
    @create 2022-01-14-21:03
    使用同步方法解决实现Runnable接口的线程安全问题

    关注同步方法的总结：
    1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
    2.非静态的同步方法，同步监视器是:this
      静态的同步方法，同步监视器是：当前类本身

*/
class Win implements Runnable{
    private int tickets = 1;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private synchronized void show(){//同步监视器：this
//        synchronized(this){
            if (tickets <= 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + tickets);
                tickets++;
            }
//        }
    }
}
public class WindowsTest3 {
    public static void main(String[] args) {
        Win w1 = new Win();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t1.start();
        t2.setName("窗口2");
        t2.start();
        t3.setName("窗口3");
        t3.start();
    }
}
