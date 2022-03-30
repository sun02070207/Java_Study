package ThreadPool;/*
    @description
    @author Serenity
    @create 2022-01-15-15:50

    创建线程的方法四：使用线程池

好处：
>提高响应速度（减少了创建新线程的时间）
>
>降低资源消耗（重复利用线程池中线程，不需要每次都创建）
>
>便于线程管理
>√corePoolSize：核心池的大小
>√maximumPoolSize：最大线程数
>√keepAliveTime：线程没有任务时最多保持多长时间后会终止

面试题：创建多线程有几种方式？四种

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ThreadPools extends Thread{
    private int num;

    public ThreadPools(int num) {
        this.num = num;
    }
    //求num的质数
    public void run(){
        boolean isFlag = true;
        for (int i = 2; i <= num; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(Thread.currentThread().getName() + "为:" + i);
            }
            isFlag = true;
        }
    }
}
class ThreadPools1 extends Thread implements Runnable{
    private int num;

    public ThreadPools1(int num) {
        this.num = num;
    }
    //求num的非质数
    public void run(){
//        boolean isFlag = true;
        for (int i = 2; i <= num; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    System.out.println(Thread.currentThread().getName() + "为:" + i);
                    continue;
                }else {
                    break;
                }
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args){
//        1.提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        System.out.println(executorService.getClass());//class java.util.concurrent.ThreadPoolExecutor

        //由于ExecutorService是接口，无法直接调用属性与方法，向下转型
        ThreadPoolExecutor t1 = (ThreadPoolExecutor) executorService;
//       设置线程池的属性
        t1.setCorePoolSize(15);
//        t1.setKeepAliveTime(1, TimeUnit.SECONDS);

//        2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        ThreadPools tp1 = new ThreadPools(50);
        ThreadPools1 threadPools1 = new ThreadPools1(50);
        tp1.setName("质数");
        threadPools1.setName("非质数");
        executorService.execute(tp1);//适合使用于Runnable
        executorService.execute(threadPools1);//适合使用于Runnable
//        executorService.submit();//适合使用于Callable

        //关闭连接池
        executorService.shutdown();
    }
}
