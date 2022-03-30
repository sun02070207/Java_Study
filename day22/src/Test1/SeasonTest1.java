package Test1;/*
@author Serenity
@create 2022-02-06-17:49

使用enum关键字定义枚举类
说明：定义的枚举类默认继承于java.lang.Enum类
*/

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString
        System.out.println(summer);
//        System.out.println(Season1.class.getSuperclass());
        System.out.println("**************************");
        //values(): 查询枚举类中含有多少状态值
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++){
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("**************************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++){
            System.out.println(values1[i]);
        }
        System.out.println("**************************");
        //valueOf(String objName): 返回枚举类中对象名是objName的对象。

        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
//        winter.show();


    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    //1. 提供当前枚举类的多个对象，多个对象之间用”,“隔开，末尾对象";"结束
    SPRING("春天", "春暖花开"){
//        情况二：在枚举类的对象中分别实现接口中的抽象方法
        public void show(){
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        public void show(){
            System.out.println("他夏了他的夏天");
        }
    },
    AUTUMN("秋天", "秋风送爽"){
        public void show(){
            System.out.println("稻香");
        }
    },
    WINTER("冬天", "寒冬凛凛"){
        public void show(){
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;


    //3. 私有化类的构造器,并给属性对象初始化赋值
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    //4. 其他诉求1：获取枚举类对象的属性
    public String getSeasonName(){
        return seasonName;
    }
    public String getSeasonDesc(){
        return  seasonDesc;
    }
    //4. 其他所求2：重写toString方法
//    public String toString(){
//        return "Season{ " +
//                "seasonName = '" + seasonName +'\'' +
//                ", seasonDesc = '" + seasonDesc + '\'' + '}';
//    }


//    情况一：实现接口，在enum类中实现抽象方法
//    public void show(){
//        System.out.println("展现接口方法");
//    }
}

