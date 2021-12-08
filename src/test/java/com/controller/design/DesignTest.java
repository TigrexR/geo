package com.controller.design;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DesignTest {

    @Test
    public void main(){
        Father father = new Father();
        Map outputData = new HashMap();
        outputData.put("name", "娟");
        father.doSomething(outputData);

        Child child = new Child();
        child.doSomething(outputData);
    }
}

class Father {

    public void doSomething(Map inputData){
        System.out.println("父亲干了！" + inputData.toString());
    }
}

class Child extends Father{

    @Override
    public void doSomething(Map inputData) {
        System.out.println("儿子也干了！" + inputData.toString());
    }

    public void doSomething(HashMap inputData){
        System.out.println("儿子又干了！" + inputData.toString());
    }

}

