package com.controller.Thread;

import org.junit.Test;

import java.util.concurrent.Callable;

public class WaitAndNotify {

    final static Object object = new Object();
    public static class T1 implements Runnable, Callable{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T1 is start");
                System.out.println(System.currentTimeMillis() + ":T1 begin wait");
                try {
                    System.out.println(Thread.currentThread().getName());
                    object.wait();
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 is end");
            }

        }

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    public static class T2 implements Runnable, Callable{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T2 is start");
                System.out.println(System.currentTimeMillis() + ":T2 is notify T1");
                object.notify();
//                object.notifyAll();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T2 is end");
            }

        }

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    @Test
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
//        Thread t3 = new Thread(new T1());
        t1.start();
        t2.start();
//        t3.start();
        System.out.println(Thread.currentThread().getName());
        System.out.println("main is end");
    }


}
