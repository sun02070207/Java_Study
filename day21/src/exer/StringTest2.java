package exer;/*
@author Serenity
@create 2022-01-17-16:29

获取一个字符串在另一个字符串中出现的次数。
比如：获取“ab”在“abkkcadkabkebfkabkskab”中出现的次数
*/

import org.junit.Test;

import javax.security.auth.login.CredentialNotFoundException;

public class StringTest2 {
    /**
     * 获取s2在s1中出现的次数
     * @param s1
     * @param s2
     * @return
     */
    public int getCount(String s1, String s2){
        int s1Length = s1.length();
        int s2Length = s2.length();
        int count = 0;
        int index = 0;
        if (s1Length > s2Length){
            //方式一
//            while((index = s1.indexOf(s2)) != -1){
//                count++;
//                s1 = s1.substring(index + s2.length());
//            }
            //方式二：对方式一改进
            while ((index = s1.indexOf(s2, index)) != -1 ){
                count++;
                index += s2Length;
            }
            return count;
        }else {
            return 0;
        }
    }
    @Test
    public void test1(){
        String mains = new String("abkkcadkabkebfkabkskab");
        String subs = new String("ab");
        System.out.println(getCount(mains, subs));
    }
}
