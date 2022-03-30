package Test1111;/*
@author Serenity
@create 2022-02-16-19:54
*/

import java.util.List;

/**
 * 举例说明：泛型类和泛型方法的使用情景
 * DAO(Data(base) access object)数据访问对象
 */

public class DAO<T> { //操作表的共性操作的DAO
    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){
        return false;
    }
    //修改一条记录
    public void set(int index, T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }

    //泛型方法
    //举例：获取表中一个多少条记录？通常用Long型。获取员工的最大入职时间？
    public <E> E getValue(){
        return null;
    }
}
