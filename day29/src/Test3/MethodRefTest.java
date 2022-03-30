package Test3;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("消费大国");
		System.out.println();

		PrintStream ps = System.out;
		Consumer<String> con2 = ps :: println;
		con2.accept("卷");
		
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee e1 = new Employee(1, "Jerry", 28, 300000);
		Supplier<String> s = () -> e1.getName();
		System.out.println(s.get());

		System.out.println();
		Employee e2 = new Employee(1, "Jerry", 28, 300000);
		Supplier<String> s1 = e2 ::getName;
		System.out.println(s1.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
		int compare = com.compare(10, 2);
		System.out.println(compare);

		Comparator<Integer> com1 = Integer :: compare;
		System.out.println(com1.compare(2, 10));

	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> fun = d -> Math.round(d);
		System.out.println(fun.apply(8.88));

		Function<Double, Long> fun1 = Math :: round;
		System.out.println(fun1.apply(9.8));

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(com.compare(1, 2)); //-1

		System.out.println();

		Comparator<String> com1 = String :: compareTo;
		System.out.println(com1.compare("123", "123")); //0
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String, String> b = (t1, t2) -> t1.equals(t2);
		System.out.println(b.test("123", "123")); //true

		System.out.println();
		BiPredicate<String, String> b1 = String :: equals;
		System.out.println(b1.test("123", "321")); //false
		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(1, "Jerry", 18, 300000.0);
		Function<Employee, String> fun = (e) -> e.getName();
		System.out.println(fun.apply(employee));//Jerry

		System.out.println();

		Function<Employee, String> fun1 = Employee ::getName;
		System.out.println(fun1.apply(employee));//Jerry
	}

}
