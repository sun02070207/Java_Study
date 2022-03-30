package Test3;/*
    @description
    @author Serenity
    @create 2022-02-25-21:39
*/

import org.junit.Test;

import java.util.Optional;
/*
Optional类：为了在程序中避免出现空指针异常而创建的。
常用的方法：ofNullable(T t)
          orElse(T t)
 */
public class OptionalTest {
    @Test
    public void test(){
        /*
        创建Optional类对象的方法：
        Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional.empty() : 创建一个空的 Optional 实例
        Optional.ofNullable(T t)：t可以为null
         */
        Girl girl = new Girl();
//        girl = null; //报空指针异常
        //of(T t):保证t是非空的
        Optional<Girl> girl1 = Optional.of(girl);
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

    }
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //ofNullable(T t): t可以为null
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);
        //orElse(T t1):如果当前的Optional内部封装的t是非空的，则返回内部的t。
        //如果内部的t是空的，则返回orElse()方法中的参数t1
        Girl girl2 = girl1.orElse(new Girl("刚子"));
        System.out.println(girl2);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);//NullPointerException
        System.out.println(girlName);
    }

    //优化以后的getGirlName()
    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName); // null
    }

    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("港深")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("沪深"));
        return girl2.getName();


    }

    @Test
    public void test4(){
//        Boy boy = null;//港深
//        Boy boy = new Boy();//沪深
        Boy boy = new Boy(new Girl("上证"));//上证
        String girlName = getGirlName2(boy);
        System.out.println(girlName); // null
    }


}
