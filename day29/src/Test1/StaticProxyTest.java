package Test1;/*
    @description
    @author Serenity
    @create 2022-02-25-9:33
*/
/*
静态代理举例
特点：代理类和被代理类在编译期间，就确定下来了。
 */
interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; //用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        //通过代理类的对象调这个方法，里面封装了同名方法的调用
        factory.produceCloth();
        System.out.println("代理工厂做了一些后续收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产一批运动服");
    }
}
//静态代理
public class StaticProxyTest {
    public static void main(String[] args){
        //创建被代理类的对象
        NikeClothFactory ncf = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(ncf);
        proxyClothFactory.produceCloth();
    }
}

