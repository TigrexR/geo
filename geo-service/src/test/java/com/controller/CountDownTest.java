package com.controller;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;

public class CountDownTest {

    /**
     * countDown 不等待线程组准备就绪，就往下跑代码
     * @param args
     * @throws InterruptedException
     */

    @Test
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
//        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class readNum  implements Runnable{

        private int id;
        private CountDownLatch latch;
        public readNum(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (this){
                try{
                    System.out.println("id:"+id);
                    latch.countDown();
                    latch.await();
                    System.out.println("线程组任务"+id+"结束，其他任务继续");
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }

    }


}
