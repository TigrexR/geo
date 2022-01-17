package com.controller;

import java.util.*;

import com.tigrex.geo.entity.User;

import org.junit.jupiter.api.Test;

/**
 * 1.存储对象可以考虑：①数组 ②集合
 * 2.数组存储对象的特点：Student[] stu = new Student[20]; stu[0] = new Student();....
 *    >弊端：①一旦创建，其长度不可变。②真实的数组存放的对象的个数是不可知。
 *    集合其实底层也是通过数组实现的
 * 3.集合
 *     Collection接口
 *     		|------List接口：存储有序的，可以重复的元素
 *     				|------ArrayList（主要的实现类）、LinkedList（对于频繁的插入、删除操作）、Vector（古老的实现类、线程安全的）
 *     		|------Set接口：存储无序的，不可重复的元素
 *     				|------HashSet、LinkedHashSet、TreeSet
 *     Map接口：存储“键-值”对的数据
 *     		|-----HashMap、LinkedHashMap、TreeMap、Hashtable(子类：Properties)
 */
public class CollectionTest {

    @Test
    public void collectionTest(){
        Collection collection = new ArrayList();
        collection.size();

        List<User> arrayList = new ArrayList<User>();

        User user = new User();
        user.setId(1).setName("george").setAge(12);
        User user1 = new User().setId(1).setName("world").setAge(123);
        User user2 = new User().setId(2).setName("world").setAge(123);
        User user3 = new User().setId(3).setName("world").setAge(123);
        User user4 = new User().setId(1).setName("world").setAge(123);
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.remove(user4);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (User i : arrayList){
            i = user4;
            System.out.println(i);
        }

        Iterator iteratorLast = arrayList.iterator();
        while (iteratorLast.hasNext()){
            System.out.println(iteratorLast.next());
        }

    }

    @Test
    public void mapTest(){


        List linkedList = new LinkedList();

        Set linkedHashSet = new LinkedHashSet();

        List vectro = new Vector();

        Map hashMap = new HashMap<String, String>();

        HashSet<User> hashSet = new HashSet<User>();


    }

    @Test
    public void setTest(){

        Set hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(345);
        hashSet.add(new String("abd"));
        hashSet.add(new String("abc"));
        User user1 = new User(1, "123", 1);
        User user2 = new User(1, "123", 1);
        hashSet.add(user1);
        hashSet.add(user2);
        System.out.println(hashSet.size());
        System.out.println(hashSet);


    }


}
