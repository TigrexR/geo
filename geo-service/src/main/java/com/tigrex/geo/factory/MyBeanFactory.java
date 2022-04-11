package com.tigrex.geo.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Linus
 */
@Component
public class MyBeanFactory implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public void setBeanName(String s) {

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
