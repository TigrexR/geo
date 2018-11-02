package com.tigrex.geo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTest {

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

}
