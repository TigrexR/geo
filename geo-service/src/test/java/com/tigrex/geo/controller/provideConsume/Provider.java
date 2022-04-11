package com.tigrex.geo.controller.provideConsume;

import org.junit.jupiter.api.Test;

public class Provider {

    public static int MAX_PRODUCT = 10;

    public static int MIN_PRODUCT = 3;

    public static int product = 0;

    @Test
    public synchronized void produce(){

        while(this.product < MIN_PRODUCT){
            this.product++;
        }

        if(this.product >= MAX_PRODUCT)
        {
            try
            {
                wait();
                System.out.println("产品已满,请稍候再生产");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }

        this.product++;
        System.out.println("生产者生产第" + this.product + "个产品.");
        notifyAll();   //通知等待区的消费者可以取出产品了
    }

    /**
     * 消费者从店员取产品
     */
    @Test
    public synchronized void consume()
    {
        if(this.product <= MIN_PRODUCT)
        {
            try
            {
                wait();
                System.out.println("缺货,稍候再取");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("消费者取走了第" + this.product + "个产品.");
        this.product--;
        notifyAll();   //通知等待去的生产者可以生产产品了
    }

}
