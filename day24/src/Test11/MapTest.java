package Test11;/*
@author Serenity
@create 2022-02-15-16:43
*/

import org.junit.Test;

import java.util.*;

/**
 * 一：Map的实现类的结构
 * |---Map: 双列数据，存储key-value对的数据  ---类似于高中的函数：y = f(x)
 *      |---HashMap: 作为Map的主要实现类；线程不安全的，效率高；可以存储null的key和value
 *          |---LinkedHashMap: 保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *              原因：在原有的HashMap底层结构的基础上，添加了一对指针，指向前一个和后一个元素。
 *              对于频繁的遍历操作，此类执行的效果高于HashMap。
 *      |---TreeMap: 保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。
 *                   底层使用红黑树
 *      |---Hashtable: 作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *          |---Properties: 常用来处理配置文件。key和value都是String类型
 *
 *      HashMap的底层：jdk7.0及以前，使用数组+链表
 *                   jdk8.0，使用数组+链表+红黑树
 *
 *
 *  两个面试题：
 *  1. HashMap的底层实现原理？
 *  2. HashMap和Hashtable的异同？上面即是答案。
 *  3. CurrentHashMap 与 Hashtable的异同？
 *
 *  二：Map结构的理解：
 *  Map中的key是无序的，不可重复的，使用Set存储所有的key。--->以HashMap为例，key所在的类要重写hashCode()和equals()方法
 *  Map中的value也是无序的，但是可重复的，使用Collection存储所有的value。—> value所在类要重写equals()方法
 * 一个键值对：key - value构成了一个Entry对象。
 * Map中的entry：无序的、不可重复的，使用Set存储所有的entry。
 *
 * 三： HashMap的底层原理（以jdk7.0为例）
 *     HashMap map = new HashMap();
 *     在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *     ...可能已经执行了多次put...
 *     map.put(key1, value1);
 *     首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到Entry数组中的存放位置。
 *     如果此位置上的数据为空，此时的key1-value1添加成功。 ---情况1
 *     如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的一个或多个数据的哈希值：
 *          如果key1的哈希值与已经存在的数据的哈希值都不相同，此时的key1-value1添加成功。 ---情况2
 *          如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)
 *                  如果equals()返回false：此时key1-value1添加成功。 ---情况3
 *                  如果equals()返回true：使用value1替换value2。
 *
 *      补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，默认的扩容方式（超出临界值，且要存放的位置非空时）：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *
 *  1.  new HashMap(): 底层没有创建一个长度为16的数组
 *
 *  2.  jdk 8底层的数组是：Node[]，而非Entry[]
 *
 *  3.  首次调用put()方法时，底层创建长度为16的数组
 *
 *  4.  jdk7 底层结构只有：数组+链表。jdk 8 中底层结构：数组+链表+红黑树。
 *
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数  > 8 且当前数组的长度 >  64时，
 *
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 *
 *
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *
 * MAXIMUM_CAPACITY： HashMap的最大支持容量，2^30
 *
 * threshold：扩容的临界值 = 容量 * 填充因子 => 12
 *
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *
 * MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量：64
 *
 * 四： LinkedHashMap的底层实现原理（了解）
 *      源码：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 * 五：
 *  添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 * 总结：
 *  填加：Object put(Object key,Object value) 、void putAll(Map m)
 *  删除：Object remove(Object key) 、void clear()
 *  修改：Object put(Object key,Object value)
 *  查询：Object get(Object key) 、 boolean containsKey(Object key) 、 boolean containsValue(Object value)
 *  长度：int size()
 *  遍历：Set keySet() 、 Collection values() 、Set entrySet()
 */
public class MapTest {
    @Test
    public void test(){
        Map map = new HashMap();
        map.put(null, null);
        System.out.println(map);
//        LinkedHashMap;
        //java.lang.NullPointerException
//        Hashtable hashtable = new Hashtable();
//        hashtable.put(null, null);
//        System.out.println(hashtable);

    }
    @Test
    public void test1(){
        /**
         *  添加、删除、修改操作：
         *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
         *  void putAll(Map m):将m中的所有key-value对存放到当前map中
         *  Object remove(Object key)：移除指定key的key-value对，并返回value
         *  void clear()：清空当前map中的所有数据
         */
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put(23, 123);
        hashMap.put(66, 663);
        hashMap.put("哈哈", 123);
        hashMap.put("Spring", 13);
        hashMap.put("Mike", 66);

        //修改
        hashMap.put(23, 123);
        hashMap.put("哈哈", 88);
        System.out.println(hashMap);

        System.out.println("***********");
        HashMap hashMap1 = new HashMap();
        hashMap1.put("LuoMan", 66);
        hashMap1.put("Luolan", 88);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);

        System.out.println("***********");

//        hashMap.remove(23, "Spring"); //{LuoMan=66, 66=663, Mike=66, Luolan=88, 23=123, 哈哈=88, Spring=13}
        hashMap.remove(23); //{LuoMan=66, 66=663, Mike=66, Luolan=88, 哈哈=88, Spring=13}
        System.out.println(hashMap);

        hashMap.clear(); // 与hashMap = null的操作不同
        System.out.println(hashMap.size()); //0
        System.out.println(hashMap); //{}

    }

    @Test
    public void test2(){
        /**
         *  元素查询的操作：
         *  Object get(Object key)：获取指定key对应的value
         *  boolean containsKey(Object key)：是否包含指定的key
         *  boolean containsValue(Object value)：是否包含指定的value
         *  int size()：返回map中key-value对的个数
         *  boolean isEmpty()：判断当前map是否为空
         *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
         */
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put(23, 123);
        hashMap.put(66, 663);
        hashMap.put("哈哈", 123);
        hashMap.put("Spring", 13);
        hashMap.put("Mike", 66);
        //Object get(Object key)
        System.out.println(hashMap.get("Mike")); //66
        //boolean containsKey(Object key)
        System.out.println(hashMap.containsKey("哈哈")); //true
        //boolean containsValue(Object value)
        System.out.println(hashMap.containsValue(123)); //找到一个就返回true
        //int size()
        System.out.println(hashMap.size()); //5
        //boolean isEmpty()
        System.out.println(hashMap.isEmpty()); //false
//        boolean equals(Object obj)
        HashMap hashMap1 = new HashMap();
        //添加
        hashMap1.put(23, 123);
        hashMap1.put(66, 663);
        hashMap1.put("哈哈", 123);
        hashMap1.put("Spring", 13);
        hashMap1.put("Mike", 66);
        System.out.println(hashMap1.equals(hashMap)); //true

    }

    @Test
    public void test3(){
        /**
         *  元视图操作的方法：
         *  Set keySet()：返回所有key构成的Set集合
         *  Collection values()：返回所有value构成的Collection集合
         *  Set entrySet()：返回所有key-value对构成的Set集合
         */
        HashMap hashMap = new HashMap();
        //添加
        hashMap.put(23, 123);
        hashMap.put(66, 663);
        hashMap.put("哈哈", 123);
        hashMap.put("Spring", 13);
        hashMap.put("Mike", 66);
        //获取key值
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //获取value值
        Collection values = hashMap.values();
        for (Object obj:
             values) {
            System.out.println(obj);
        }
        System.out.println();
        //获取key-value对
        //方式一
        Set set1 = hashMap.keySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object key = iterator1.next();
            Object value = hashMap.get(key); //bject get(Object key):获取指定key对应的value
            System.out.println(key + "-->" + value);
        }
        System.out.println();
        //方式2
        Set set2 = hashMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "," + entry.getValue());
        }

    }

}
