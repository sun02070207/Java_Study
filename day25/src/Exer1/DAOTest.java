package Exer1;/*
@author Serenity
@create 2022-02-17-13:00
*/

import org.junit.Test;

import java.util.List;

/**
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 */
public class DAOTest {
    @Test
    public void test(){
        DAO<User> dao = new DAO<>();
        dao.save("1", new User(1, 34, "周杰伦"));
        dao.save("2", new User(2, 20, "AngelBaby"));
        dao.save("3", new User(3, 21, "宫斗大戏"));

//        System.out.println(dao.list());
        //jdk8.0的新特性
        List<User> list = dao.list();

        list.forEach(System.out::println); //User{id=1, age=34, name='周杰伦'}
//        User{id=2, age=20, name='AngelBaby'}
//        User{id=3, age=21, name='宫斗大戏'}

        dao.update("2", new User(2, 35, "方文山"));
        List<User> list1 = dao.list();
        list1.forEach(System.out::println);//User{id=1, age=34, name='周杰伦'}
//        User{id=2, age=35, name='方文山'}
//        User{id=3, age=21, name='宫斗大戏'}

        dao.delete("3");
        System.out.println(dao.list()); //[User{id=1, age=34, name='周杰伦'}, User{id=2, age=35, name='方文山'}]

    }
}
