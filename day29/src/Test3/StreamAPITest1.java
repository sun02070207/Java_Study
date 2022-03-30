package Test3;/*
    @description
    @author Serenity
    @create 2022-02-25-20:40
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest1 {
    @Test
    public void test(){
        /*
        1-匹配与查找
         */
        List<Employee> list = EmployeeData.getEmployees();
//        allMatch(Predicate p) 检查是否匹配所有元素
        //练习：是否所有的员工年龄都大于35岁
        boolean b = list.stream().allMatch(employee -> employee.getAge() > 30);
        System.out.println(b); //false
//        anyMatch(Predicate p) 检查是否至少匹配一个元素
        //练习：是否存在员工的工资大于10000
        boolean b1 = list.stream().anyMatch(employee -> employee.getSalary() > 10000);
        System.out.println(b1); //false
//        noneMatch(Predicate p) 检查是否没有匹配所有元素
        //练习：是否存在员工型“雷”
        boolean b2 = list.stream().noneMatch(employee -> employee.getName().startsWith("雷"));
        System.out.println(b2); //false
//        findFirst() 返回第一个元素
        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first); //Optional[Employee{id=1001, name='马化腾', age=34, salary=6000.38}]
//        findAny() 返回当前流中的任意元素
        Optional<Employee> any = list.parallelStream().findAny();  //Optional[Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}]
        System.out.println(any); //Optional[Employee{id=1006, name='比尔盖茨', age=42, salary=9500.43}]
//        count() 返回流中元素总数
        long count = list.stream().filter(employee -> employee.getSalary() > 5000).count();
        System.out.println(count);
//        max(Comparator c) 返回流中最大值
        //返回最高的工资
        Optional<Double> max = list.stream().map(employee -> employee.getSalary()).max(Double::compare);
        System.out.println(max);
//        min(Comparator c) 返回流中最小值
        //返回工资最低的员工(此练习不需要映射)
        Optional<Employee> minemployee = list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(minemployee);

//        forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭 代——它帮你把迭代做了)
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test1(){
        //2-归约
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1：计算1-10自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2：计算公司所有员工工资的总和
        List<Employee> list1 = EmployeeData.getEmployees();
        Stream<Double> getSalary = list1.stream().map(employee -> employee.getSalary());
        Optional<Double> sumSalary = getSalary.reduce(Double::sum);
        System.out.println(sumSalary);
    }

    @Test
    public void test3(){
        //3-收集
//        collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回一个List或Set
        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> employeeList = list.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        //改成set
        Set<Employee> collect = list.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collect.forEach(System.out::println);

    }
}
