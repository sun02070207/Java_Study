package Test3;/*
    @description
    @author Serenity
    @create 2022-02-25-18:26
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    /*
    测试Stream方式一：通过集合
     */
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    /*
    测试Stream方式一：通过数组
     */
    @Test
    public void test2(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1, "Bob");
        Employee e2 = new Employee(2, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    //创建Stream方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }
    //创建Stream方式四：创建无限流
    @Test
    public void test4(){
//          迭代
//        public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out :: println);

//          生成
//        public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
    }
}
