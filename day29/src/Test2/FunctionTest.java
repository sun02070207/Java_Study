package Test2;/*
    @description
    @author Serenity
    @create 2022-02-25-15:26
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
函数式接口
 */
public class FunctionTest {
    @Test
    public void test(){
        happytime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("一天能赚多少钱：" + aDouble + "元");
            }
        });

        System.out.println();

        //lambda表达式
        happytime(900, money -> System.out.println("涨过工资一天多少钱：" + money + "元"));
    }

    public void happytime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test1(){
        List<String> list = Arrays.asList("北京", "南京", "东京", "洛阳", "重阳");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        List<String> filterStrs1 = filterString(list, s -> s.contains("阳"));
        System.out.println(filterStrs1);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
