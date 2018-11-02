package com.tigrex.geo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoxTest {

    @Test
    public void main(){

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

}
