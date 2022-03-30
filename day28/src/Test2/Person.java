package Test2;/*
    @description
    @author Serenity
    @create 2022-02-24-16:16
*/
@MyAnnotation(value = "hei")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{
    private String name;
    int age;
    public int id;
    @MyAnnotation
    public Person(){

    }
    private Person(String name){
        this.name = name;
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation(value = "hoho")
    private String getNation(String nation){
        System.out.println("国籍是：" + nation);
        return nation;
    }
    @MyAnnotation
    public String display (String interests, int year) throws Exception, NumberFormatException{
        return interests + year;
    }
    @Override
    public void show() {
        System.out.println("是一个人。");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("变有钱");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
