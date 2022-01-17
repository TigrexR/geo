package com.tigrex.geo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class PhoneTest {

    @Test
    public void phone(){
        List<Long> phone = new ArrayList();
        phone.add(1570006947L);
        phone.add(1570006946L);
        phone.add(1570006945L);
        phone.add(1570006944L);
        phone.add(1570006943L);
        phone.add(1570006942L);
        phone.add(1570006941L);
        phone.add(1570006948L);
        phone.add(1570006949L);
        phone.add(1560006947L);
        phone.add(1550006947L);
        phone.add(1540006947L);
        phone.add(1540006948L);
        System.out.println(phone.toString());

        List<Long> list = phone.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list.toString());

        Map<Long, List<Long>> data = new HashMap<>();
        List<Long> value = new ArrayList();
        Long key = list.get(0) - list.get(0) % 100;
        value.add(list.get(0));
        data.put(key, value);
        for (int i = 1; i < list.size(); i++) {
            Long phoneNum = list.get(i);
            if(phoneNum - key < 100){
                value.add(phoneNum);
            } else {
                key = list.get(i) - list.get(i) % 100;
                value = new ArrayList();
                value.add(list.get(i));
            }
            data.put(key, value);
        }
        System.out.println(data.toString());

        for (Map.Entry<Long, List<Long>> set : data.entrySet()){
            System.out.println(set.getValue().size());
        }

    }

}
