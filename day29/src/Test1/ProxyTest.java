package Test1;/*
    @description
    @author Serenity
    @create 2022-02-25-9:50
*/
/*
动态代理的举例
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();

    void eat(String food);
}
//被代理类1
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "为了信仰！";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢吃" + food);
    }
}
//被代理类2
class SuperWoman implements Human{

    @Override
    public String getBelief() {
        return "为了和平！";
    }

    @Override
    public void eat(String food) {
        System.out.println("喜欢吃辣的和" + food);
    }
}
class HumanUtil{
    public void method1(){
        System.out.println("************通用方法1**************");
    }
    public void method2(){
        System.out.println("************通用方法2**************");
    }
}
/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
答：建立一个XxxFactory类
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a？
答：实现InvocationHandler接口
 */
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
       MyInvocationHandler handler = new MyInvocationHandler();
       handler.bind(obj);
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }
}
class MyInvocationHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }
    //当通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1(); //动态代理中增加通用方法
        //将被代理类要指定的方法a的功能就声明在invoke()中
        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj：被代理类的对象
        Object invoke = method.invoke(obj, args);
        humanUtil.method2();
        //上述方法的返回值就作为当前类的invoke()的返回值
        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动地调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("北京烤鸭");
        System.out.println("*********************************");
        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();
        System.out.println("*********SuperWoman******");
        SuperWoman superWoman = new SuperWoman();
        Human proxyInstance2 = (Human) ProxyFactory.getProxyInstance(superWoman);
        String belief1 = proxyInstance2.getBelief();
        System.out.println(belief1);
        proxyInstance2.eat("麻辣烫");
    }
}
