package TestPackage;/*
    @description
    @author Serenity
    @create 2022-01-14-14:25

    例子:创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
    依然存在线程安全问题，待解决
    安全情况的一种：窗口1: 卖票，票号为：0
                 窗口3: 卖票，票号为：0
    加入sleep的安全情况：窗口1: 卖票，票号为：102

    1.问题总结：卖票过程中，出现了重票、错票--->线程安全问题
    2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
    3.如何解决：当一个线程在操作ticket的时候，其他线程不能参与进来。直到线程A操作完ticket时，其他
              线程才可以开始操作ticket。这种情况，即使在线程A出现了阻塞，也不能被改变。
    4.在Java中，我们通过同步机制，来解决线程的安全问题。


    方式一：同步代码块
        synchronized(同步监视器){
            //需要被同步的代码
        }
        说明：1.操作共享数据的代码，即为需要被同步的代码。 -->不能包含代码多了，也不能包含代码少了
             2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
             3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
               要求：多个线程必须要共用同一把锁。

             补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
    方式二：同步方法
        如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。

    5.同步的方式，解决了线程的安全问题。--（好处）
      操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。--（坏处）
*/

class MyWindows implements Runnable{
    private int tickets = 1;
    Object obj = new Object();
    @Override
    public void run() {
//        Object obj = new Object();  //此时就不满足同一把锁的要求。
        for (;;) {
            synchronized (this) {//此时的this：唯一的MyWindows的对象 //方式二：synchronized (obj)
                if (tickets <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + tickets);
                    tickets++;
                } else {
                    break;
                }
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
