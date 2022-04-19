package com.tigrex.geo.spring;

import com.tigrex.geo.GeoApplication;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTests {

    @Test
    public void BeanDefinitionTests() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
        System.out.println("Hello spring!");
    }
}
