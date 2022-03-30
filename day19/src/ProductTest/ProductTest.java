package ProductTest;/*
    @description
    @author Serenity
    @create 2022-01-15-14:22

    线程通信的应用：经典例题：生产者/消费者问题

    生产者（Productor）将产品交给店员（Clerk），
    而消费者（Customer）从店员处取走产品，
    店员一次只能持有固定数量的产品（比如：20），
    如果生产者试图生产更多的产品，店员会叫生产者停一下，
    如果店中有空位放产品了再通知生产者继续生产；
    如果店中没有产品了，店员会告诉消费者等一下，
    如果店中有产品了再通知消费者来取走产品。

    分析：
    1.是否是多线程问题？是，生产者线程，消费者线程
    2.是否有共享数据？是，店员（或产品）
    3.如何解决线程的安全问题？同步机制，有三种方法。
    4.是否涉及线程的通信？是
*/

import sun.security.provider.ConfigFile;

import java.time.chrono.IsoChronology;

class Clerk{
    private int productCount = 0;
    //生产产品
    public synchronized void productorProduct() {
        if (productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + productCount + "产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumerProduct() {
        if (productCount > 0){
            productCount--;
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productCount + "产品");
            notify();
        }else {
            try {
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Productor extends Thread{
    private Clerk clerk;
    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产");
        while (true) {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.productorProduct();
        }    
    }
}
class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    public void run(){
        System.out.println(getName() + ": 开始消费");
        while (true){
            try {
                sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        Consumer consumer1 = new Consumer(clerk);

        productor.setName("生产者");
        consumer.setName("消费者");
        consumer1.setName("消费者1");

        productor.start();
        consumer.start();
        consumer1.start();
    }
}
