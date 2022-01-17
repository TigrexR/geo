package com.controller.Thread;

import com.javaBase.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorTest {

    @Test
    public void main(){

//        for (int i = 0; i < 10; i++) {
//            Thread t1 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String a = UUID.randomUUID().toString().replace("-", "");
//                    System.out.println(a);
//                }
//            });
//
//            t1.start();
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        List<Future<String>> futures = new ArrayList<>();
        Set<Callable<String>> set = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            Callable<String> callable = new Callable<String>() {//创建callable
                @Override
                public String call() throws Exception {
                    User user = new User();
                    synchronized (user) {
                        user.setId((int)(1+Math.random()*10000));
//                        System.out.println(user.toString());
                        //thread code
                        return user.toString();
                    }
                }
            };
            set.add(callable);//add进set集合
        }

        try {
            futures = executorService.invokeAll(set);//同时调用所有callable
            for (Future<String> info : futures) {
                try {
                    System.out.println(info.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
