package ThreadTest1;/*
    @description
    @author Serenity
    @create 2022-01-13-21:26
    练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
*/

public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        MyThread1 myThread1 = new MyThread1();
//        myThread.start();
//        myThread1.start();
//          创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "\t" + i + "是奇数。");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "\t" + i + "是偶数。");
                    }
                }
            }
        }.start();
    }
}
//class MyThread extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++){
//            if (i % 2 != 0){
//                System.out.println(Thread.currentThread().getName() + "\t" + i + "是奇数。");
//            }
//        }
//    }
//}
//class MyThread1 extends Thread{
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++){
//            if (i % 2 == 0){
//                System.out.println(Thread.currentThread().getName() + "\t" + i + "是偶数。");
//            }
//        }
//    }
//}