package Test1;/*
    @description
    @author Serenity
    @create 2022-01-16-16:55
*/




public class StringReversal {
    public static String reverseString(String str, int start, int end) {
        char[] c = str.toCharArray();//字符串--->字符数组
        return reverseArray(c, start, end);
    }
    public static String reverseArray(char[] c,int start,int end){
        for(int i = start,j = end;i < j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        //字符数组--->字符串
        return new String(c);
    }
    //方式二
    public static String reverseString1(String str,int start,int end){
        String str1 = str.substring(0, start);
        for(int i = end;i >= start;i--){
            char c = str.charAt(i);
            str1 += c;
        }

        str1 += str.substring(end + 1);
        return str1;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseString(s, 2, 5));
    }
}