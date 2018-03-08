package com.watent.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Dylan
 * @date 2018/3/7 21:51
 **/
public class Processor1 implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("Processor1 BeanFactoryPostProcessor.postProcessBeanFactory()");

        BeanDefinition bd = beanFactory.getBeanDefinition("student");
        MutablePropertyValues mpv = bd.getPropertyValues();
        mpv.addPropertyValue("password", "123456-abc");
    }
}
