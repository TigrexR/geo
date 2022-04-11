package com.tigrex.geo.controller.Thread;

import java.util.concurrent.Callable;

import org.junit.jupiter.api.Test;

public class RunnableTest implements Runnable, Callable {

    static int i = 0;

    static RunnableTest instance = new RunnableTest();

    @Test
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(instance);
        Thread threadTwo = new Thread(instance);
        Thread threadThree = new Thread(instance);

        Thread threadFour = new Thread(new RunnableTest());
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
//            synchronized (instance){
//                ++i;
//            }
            addI();
        }
    }

    @Override
    public Object call() throws Exception {
        return i;
    }

    public static synchronized void addI(){
        ++i;
    }
}
