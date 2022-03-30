package ExerPackage;/*
    @description
    @author Serenity
    @create 2022-01-15-10:07

    银行有一个账户：
    有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。

    分析：
    1.是否是多线程问题？是，两个储户线程
    2.是否有共享数据？有，账户（或账户余额）
    3.是否有线程安全问题？在有共享数据的情况下，会有。
    4.需要考虑如何解决线程安全问题？同步机制：三种方式
*/
class Account{
    private int balance;
    public Account(int balance){
        this.balance = balance;
    }
    //存钱方法
    public void deposit(int act){
        if (act > 0){
            synchronized(Account.class) {  //使用的同步代码块方法
                try {
                    Thread.sleep(20);
                    balance += act;
                    System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
class Customer extends Thread{
    private Account act;
    public Customer(Account act){
        this.act = act;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            act.deposit(1000);
        }

    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("用户1");
        c2.setName("用户2");
        c1.start();
        c2.start();
    }
}
