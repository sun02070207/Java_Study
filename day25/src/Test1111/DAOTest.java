package Test1111;/*
@author Serenity
@create 2022-02-16-20:08
*/

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test(){
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);
        Customer customer = dao.getIndex(1);

        StudentDAO dao1 = new StudentDAO();
        dao1.add(new Student());
        Student student = dao1.getIndex(1);

    }
}
