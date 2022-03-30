package WindowsTest;/*
    @description
    @author Serenity
    @create 2022-01-14-10:19
    例子：创建三个窗口卖票，总票数100张。
    存在线程安全问题，待解决
*/
class Windows extends Thread{
    private static int ticket = 0; //加入static，每个对象共享一个静态变量

    @Override
    public void run() {
        while (true){
            if (ticket < 100){
                System.out.println(getName() + ": 卖票，票号为：" + ticket);
                ticket++;
            }else {
                break;
            }
        }
    }
}
public class WindowsTest {
    public static void main(String[] args){
        Windows w1 = new Windows();
        Windows w2 = new Windows();
        Windows w3 = new Windows();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
