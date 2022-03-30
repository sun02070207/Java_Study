package exer;/*
@author Serenity
@create 2022-01-17-20:52

4.获取两个字符串中最大相同子串。比如：
str1="abcwerthelloyuiodef"；str2="cvhellobnm"
提示：将短的那个串进行长度依次递减的子串与较长的串比较。
*/

import org.junit.Test;

import java.util.Arrays;

public class StringTest3 {
    public String getMax(String str1, String str2){
//        StringBuilder stringBuilder = new StringBuilder(str1);
//        StringBuilder stringBuilder1 = new StringBuilder(str2);
//        StringBuilder maxStringBuilder = (stringBuilder.length() >= stringBuilder1.length())? stringBuilder : stringBuilder1;
//        StringBuilder minStringBuilder = (stringBuilder.length() < stringBuilder1.length())? stringBuilder : stringBuilder1;
//        int start = 0;
//        int end = maxStringBuilder.length();
//        for (int i = 0; i < maxStringBuilder.length(); i++){
//            minStringBuilder = maxStringBuilder.substring(start, end);
//        }
        if (str1 != null && str2 != null){
            String maxString = (str1.length() >= str2.length())? str1 : str2;
            String minString = (str1.length() < str2.length())? str1 : str2;
            int length = minString.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++){
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)){
                        return subString;
                    }
                }

            }
        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameSubString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
//                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }
    @Test
    public void test(){
        String s1 = new String("abcwerthelloyuiodef");
        String s2 = new String("cvhellobnm");
        System.out.println(getMax(s1, s2));
    }
    @Test
    public void test1(){
        String s1 = "abcwerthello1yuiodefabcdef";
        String s2 = "cvhello1bnmabcdef";
        String[] s3 = getMaxSameSubString1(s1, s2);
        System.out.println(Arrays.toString(s3));
    }
}
