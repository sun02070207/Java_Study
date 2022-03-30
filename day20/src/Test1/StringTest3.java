package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-14:41
 String replace(char oldChar, char newChar)：返回一个新的字符串，它是
通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

 String replace(CharSequence target, CharSequence replacement)：使
用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。

 String replaceAll(String regex, String replacement) ： 使 用 给 定 的
replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

 String replaceFirst(String regex, String replacement) ： 使 用 给 定 的
replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

 boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。

 String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。

 String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
*/

import org.junit.Test;

public class StringTest3 {
    @Test
    public void test(){
        String str = "helloWorldhello";
        String str1 = str.replace('o', 'O');
        System.out.println(str);//helloWorldhello
        System.out.println(str1);//hellOWOrldhellO

        String str2 = str.replace("ll", "LL");
        System.out.println(str2);//heLLoWorldheLLo
        System.out.println("***************");
        String str3 = "12hello34world5java7891mysql456";
        //replaceAll : 把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        //^代表开头，$代表结尾
        String string = str3.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);

        String str4 = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str4.matches("\\d+");
        System.out.println(matches); //true
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result); //true

        //切片
        String str5 = "hello|world|java";
        String[] strs = str5.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str6 = "hello.world.java";
        String[] strs6 = str6.split("\\.");
        for (int i = 0; i < strs6.length; i++) {
            System.out.println(strs6[i]);
        }
    }
}
