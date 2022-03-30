package ThreadMethodeTest;/*
    @description
    @author Serenity
    @create 2022-01-13-21:40
    测试Thread中的常用方法：
    1. start():启动当前线程：调用当前线程的run()
    2. run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
    3. currentThread():静态方法，返回执行当前代码的线程
    4. getName():获取当前线程的名字
    5. setName():设置当前线程的名字
    6. yield():释放当前cpu的执行权
    7. join():在线程A中调用线程B的join()方法，此时线程A就进入阻塞状态，直到线程B完全执行完以后，线程A
              才结束阻塞状态。
    8. stop():（该方法已过时，不建议使用。）方法含义：当执行此方法时，强制结束当前线程。
    9. sleep(long milltiome):让当前线程”睡眠“指定的millitime毫秒。在指定的millitime毫秒时间内，当前
                                线程是阻塞状态。
    10.isAlive():判断当前线程是否存活。

    线程的优先级：
    1.MAX_PRIORITY: 10      MIN_PRIORITY: 1     NORM_PRIORITY: 5

    如何获取和设置当前线程优先级：
    1.getPriority()：返回线程优先级
    2.setPriority(int newPriority):改变线程的优先级
    说明：高优先级的线程要抢占低线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的
    情况下被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
*/
class HelloTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            //由于子类重写的父类的方法没有throws抛出异常，子类不能抛出比父类范围更大的异常，故不能throws
            if (i % 2 != 0){
//                try {
////                    Thread.sleep(10);  //sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ": " + currentThread().getPriority() + "\t" + i + "是奇数。");
            }
            if (i % 20 == 0){
                this.yield();
            }
        }
    }
    public HelloTest(String name){//利用构造器设置线程名字
        super(name);
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloTest h1 = new HelloTest("线程一");
//        h1.setName("线程1");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority() + "\t" + i + "是偶数。");
            }
            if (i == 20){
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(h1.isAlive());
    }
}
