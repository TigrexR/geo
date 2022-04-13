package com.tigrex.geo.controller;

/**
 * @author linus
 */
public class JoinThreadTest {

    public static void main(String[] args) throws InterruptedException {
        JoinTread joinTread = new JoinTread();
        joinTread.start();
        joinTread.join();
        System.out.println();
    }

    public static class JoinTread extends Thread{

        @Override
        public void run() {

        }
    }
}
