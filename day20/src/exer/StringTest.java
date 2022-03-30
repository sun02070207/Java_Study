package exer;/*
    @description
    @author Serenity
    @create 2022-01-15-22:11
    面试题
*/

public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
        System.out.println(str); //根据String不可变性
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str); // good //str的地址值是堆空间开辟空间后的地址值
        System.out.println(ex.ch); //best

    }
    public void prime(){
        boolean isFlag = true;
        for (int i = 2; i <= 1000; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.println(i);
            }
            isFlag = true;
        }
    }
}
