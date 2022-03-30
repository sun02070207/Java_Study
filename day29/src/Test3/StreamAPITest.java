package Test3;/*
    @description
    @author Serenity
    @create 2022-02-25-19:24
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest {
    //测试Stream的中间操作
    @Test
    public void test(){
        //1-筛选与切片
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();

        //        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        //查询员工表中薪资大于7000的员工信息
        stream.filter(employee -> employee.getSalary() > 7000).forEach(System.out :: println);
        System.out.println();
        //        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
//        System.out.println(list);
        list.stream().distinct().forEach(System.out :: println);
        System.out.println();
        //        limit(long maxSize) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out :: println);
        System.out.println();
        //        skip(long n)  跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(3).forEach(System.out :: println);

    }

    //2-映射
    @Test
    public void test1(){
        List<String> list = Arrays.asList("a", "c", "a");
//        map(Function f) 接收一个函数作为参数，该函数会被应用到每个元 素上，并将其映射成一个新的元素。
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);

        //练习1：获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameString = employees.stream().map(Employee::getName);
        nameString.filter(name -> name.length() > 3).forEach(System.out :: println);
        System.out.println();
        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out :: println));//stream构成的stream
        System.out.println();
//        flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        characterStream.forEach(System.out :: println);

//        mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 DoubleStream。

//        mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 IntStream。

//        mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 LongStream。


    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ArrayList list1 = new ArrayList();
        list1.add(5);
        list1.add(6);
        list1.add(7);

//        list.add(list1); //[1, 2, 3, 4, [5, 6, 7]]
        list.addAll(list1); //[1, 2, 3, 4, 5, 6, 7]
        System.out.println(list);

    }

    //3-排序
    @Test
    public void test3(){
//        sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 3, 2, 747, 8, 768, -6, 57, 6, 66);
        list.stream().sorted().forEach(System.out :: println);
        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> list1 = EmployeeData.getEmployees();
//        list1.stream().sorted().forEach(System.out :: println);
        System.out.println();
//        sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        List<Employee> list1 = EmployeeData.getEmployees();
        list1.stream().sorted((e1, e2) ->{
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0){
                return compare;
            }else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out :: println);
    }
}
