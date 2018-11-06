package com.tigrex.geo;

import com.alibaba.fastjson.JSONObject;
import com.tigrex.geo.entity.TestObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EverythingTest {

    @Test
    public void objTest(){
        TestObject testObject = new TestObject();
        testObject.setBase_info(testObject.new BaseInfo()
                .setAge(1)
                .setName("george"));
        List<TestObject.BaseInfo> baseList = new ArrayList<>();
        baseList.add(testObject.new BaseInfo().setAge(1).setName("James"));
        baseList.add(testObject.new BaseInfo().setAge(2).setName("Antetokounmpo"));
        baseList.add(testObject.new BaseInfo().setAge(3).setName("Curry"));
        testObject.setBase_list(baseList);
        String jsonString = JSONObject.toJSONString(testObject);
        System.out.println(testObject);
        System.out.println(jsonString);
    }

}
