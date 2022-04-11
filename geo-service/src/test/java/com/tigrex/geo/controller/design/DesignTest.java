package com.tigrex.geo.controller.design;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class DesignTest {

    @Test
    public void main(){
        Father father = new Father();
        Map<String, String> outputData = new HashMap(2);
        outputData.put("name", "娟");
        father.doSomething(outputData);

        Child child = new Child();
        child.doSomething(outputData);
    }
}

class Father {

    public void doSomething(Map<String, String> inputData){
        System.out.println("父亲干了！" + inputData.toString());
    }
}

class Child extends Father{

    @Override
    public void doSomething(Map<String, String> inputData) {
        System.out.println("儿子也干了！" + inputData.toString());
    }

    public void doSomething(HashMap<String, String> inputData){
        System.out.println("儿子又干了！" + inputData.toString());
    }

}

