package com.tigrex.geo.controller.reflection;

import org.junit.jupiter.api.Test;

public class ReflectionTest {

    @Test
    public void testOne(){

        /**
         *
        Class clazzOne = User.class;
        System.out.println(clazzOne.getName());

        User user = new User();
        Class clazzTwo = user.getClass();
        System.out.println(clazzTwo.getClasses());

        try {
            Class clazzThree = Class.forName("com.javaBase.domain.User");
            System.out.println(clazzThree.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ClassLoader clazzLoad = this.getClass().getClassLoader();
            Class clazzFour = clazzLoad.loadClass("com.javaBase.domain.User");
            System.out.println(clazzFour.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         */


        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println(systemClassLoader.getParent().getName());
        System.out.println(platformClassLoader.getName());

    }

}
