package com.tigrex.geo;

import com.tigrex.geo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeTest {
    
    int status = 1;

    @Test
    public void stringTest(){
        //stringbuffer
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello world");
        stringBuffer.append("---bye world");
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.toString());
        String subStr = stringBuffer.substring(1, 4);
        System.out.println(subStr);
        stringBuffer.delete(1,4);
        System.out.println(stringBuffer.toString());

        //stringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello world");
        stringBuilder.substring(1,4);

        String s = new String();
    }

    @Test
    public void boxTest(){

        Integer num1 = 1;
        int num2 = 1;
        System.out.println(num1 == num2);

        Integer num3 = 1234;
        int num4 = 1234;
        System.out.println(num3.intValue());
        System.out.println(num3 == num4);

        Set<Integer> integerSet = new TreeSet<>();
        System.out.println(integerSet.getClass());

        List<Integer> integerList = List.of(1, 3);
        System.out.println(integerList.getClass());

        Queue<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.toString());

    }

    @Test
    public void feflectionTest(){
        try {
            Class clazz = Class.forName("com.tigrex.geo.domain.User");
            System.out.println(clazz.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void strongReferenceTest(){
        //强引用
        User george = new User().setId(1).setName("george").setAge(13);
        System.out.println(george.toString());
    }

    @Test
    public void vectorTest(){
        List<Integer> integers = new Vector();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.toString());
    }

    @Test
    public void lockTest(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ReentrantLock lock = new ReentrantLock();
                lock.lock();
                try {
                    if(status == 1){
                        status = status + 1;
                    } else {
                        status = status - 1;
                    }
                    System.out.println(status);
                } finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
    }

}
