package exer;/*
    @description
    @author Serenity
    @create 2022-01-16-21:42

    2.将一个字符串进行反转。将字符串中指定部分进行反转。
    比如“abcdefg”反转为”abfedcg”

    3.获取一个字符串在另一个字符串中出现的次数。
    比如：获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
*/

import org.junit.Test;

public class StringTest1 {
    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。
    比如“abcdefg”反转为”abfedcg”
     */

    public String reverse(String str, int start, int end){
        String s = str.substring(0 , start);
        for (int i = end; i >= start; i--){
            char c = str.charAt(i);
            s += c;
        }
        s += str.substring(end + 1);
        return s;
    }

    public static void main(String[] args) {
        StringTest1 stringTest1 = new StringTest1();
//        String s1 = new String("abcdef");
        String s2 = stringTest1.reverse("abcdef", 3, 5);
        System.out.println(s2);
    }

//    @Test
    //方法二，转换为char型数组，方式二比方式一稍微好一点
    public String reverseTest(String str, int start, int end){
        if (str != null){
            char[]  c = str.toCharArray();
            for (int x = start, y = end; x < y; x++, y--){
                char temp = c[x];
                c[x] = c[y];
                c[y] = temp;
            }
            String s1 =  new String(c);
            System.out.println(s1);
            return s1;
        }
        return null;
    }
    @Test
    public void test1(){
        String s1 = new String("abcdefgh");
        String reverseTest2 = reverseTest(s1, 2 , 5);
    }
//      不建议，写的太金克拉
//    public String reverseTest1(String str, int start, int end){
//        String s1 = str.substring(0, start);
//        String s2 = str.substring(end + 1);
//        String s3 = "";
//        for (int i = end; i > start; i--){
//            s3 = s1 + i;
//        }
//        String s4 = s3 + s2;
//
//        return null;
//    }
    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverseTest2(String str, int start, int end){
        if (str != null){
            StringBuilder sb1 = new StringBuilder(str.length());
            //第一部分，for循环
            sb1.append(str.substring(0, start));
            //第二部分，反转
            for (int i = end; i > start; i--){
                sb1.append(str.charAt(i));
            }
            //第三部分，加入最后元素
            sb1.append(str.substring(end + 1));

            return sb1.toString();
        }
        return null;
    }

}
