package Exer;/*
@author Serenity
@create 2022-02-15-14:44
*/

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private myDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, myDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public myDate getBirthday() {
        return birthday;
    }

    public void setBirthday(myDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //没有泛型
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e = (Employee) o;
//            return this.name.compareTo(e.name);
//        }else {
//            throw new RuntimeException("输出数据类型不匹配。");
//        }
//    }

    //有泛型
    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
