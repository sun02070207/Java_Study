package Exer;/*
@author Serenity
@create 2022-02-15-14:45
*/

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args){
        Comparator<Employee> com = new Comparator<Employee>() {
            //带泛型的写法
            @Override
            public int compare(Employee o1, Employee o2) {
                //省略强转
                myDate m1 = o1.getBirthday();
                myDate m2 = o2.getBirthday();
                int mintyear = m1.getYear() - m2.getYear();
                if (mintyear != 0){
                    return mintyear;
                }
                int mintmonth = m1.getMonth() - m2.getMonth();
                if (mintmonth != 0){
                    return mintmonth;
                }
                return m1.getDay() - m2.getDay();
            }
            };
//          没有泛型的写法
            //            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee){
//                    Employee employee = (Employee) o1;
//                    Employee employee1 = (Employee) o2;
////                    int yearnum = employee.getBirthday().getYear() - employee1.getBirthday().getYear();
////                    if (yearnum != 0){
////                        return yearnum;
////                    }
//                    MyDate myDate = employee.getBirthday();
//                    MyDate myDate1 = employee1.getBirthday();
////                    int monthnum = myDate.getMonth() - myDate1.getMonth();
////                    if (monthnum != 0){
////                        return monthnum;
////                    }
////                    int daynum = myDate.getDay() - myDate1.getDay();
////                    return daynum;
//                    //方式二
//                    return myDate.compareTo(myDate1);
//                }else {
//                    throw new RuntimeException("输入数据类型不匹配。");
//                }
//
//            }
//
//        };
        TreeSet<Employee> set = new TreeSet<Employee>(com);
        Employee e1 = new Employee("zhoujielun", 38, new myDate(1982, 10, 20));
        Employee e2 = new Employee("sunyingbo", 26, new myDate(1996, 2, 7));
        Employee e3 = new Employee("sunquan", 1888, new myDate(256, 10, 20));
        Employee e4 = new Employee("aili", 40, new myDate(1980, 2, 20));
        Employee e5 = new Employee("chenglong", 38, new myDate(1982, 10, 25));

        //集合中添加数据
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        //遍历集合数据
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
