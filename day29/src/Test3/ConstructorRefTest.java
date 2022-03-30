package Test3;

import org.junit.Test;
import sun.security.util.Length;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return null;
            }
        };
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());

        System.out.println();

        Supplier<Employee> supplier2 = Employee :: new;
        System.out.println(supplier2.get());
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> fun = id -> new Employee(id);
        Employee employee = fun.apply(1);
        System.out.println(employee);

        System.out.println();

        Function<Integer, Employee> fun1 = Employee :: new;
        Employee employee1 = fun1.apply(2);
        System.out.println(employee1);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer, String, Employee> bi = (id, name) -> new Employee(id, name);
        System.out.println(bi.apply(1, "Sun"));

        System.out.println();

        BiFunction<Integer, String, Employee> b2 = Employee :: new;
        System.out.println(b2.apply(2, "嘿"));


    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, Double[]> function = length -> new Double[length];
        Double[] apply = function.apply(5);
        System.out.println(Arrays.toString(apply));

        Function<Integer, Double[]> function1 = Double[] :: new;
        Double[] apply1 = function1.apply(2);
        System.out.println(Arrays.toString(apply1));
    }
}
