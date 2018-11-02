package com.tigrex.geo;

import com.tigrex.geo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceTest {

    @Test
    public void strongReferenceTest(){
        //强引用
        User george = new User().setId(1).setName("george").setAge(13);
        System.out.println(george.toString());
    }
}
