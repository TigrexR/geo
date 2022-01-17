package com.controller.Thread;

import org.junit.Test;

import java.util.concurrent.Callable;

public class JoinThreadTest {

    int i = 0;

    @Test
    public void JoinMain() throws InterruptedException {
        JoinTread joinTread = new JoinTread();
        joinTread.setName("THREADONE");
        joinTread.start();
        joinTread.join();
        Thread thread = new Thread(new JoinInterfaceThread());
        System.out.println(Thread.currentThread().getName());
        System.out.println("大家一起走！" + i);
    }

    public class JoinTread extends Thread{

        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                ++i;
            }
            System.out.println(Thread.currentThread().getName() + "执行完成！" + i);
        }
    }

    public class JoinInterfaceThread implements Runnable, Callable{

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                ++i;
            }
            System.out.println(i);
        }

        @Override
        public Object call() throws Exception {
            return "123";
        }
    }
}
