package com.watent.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author Dylan
 * @date 2018/3/7 21:51
 **/
public class Processor2 implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("Processor2 BeanFactoryPostProcessor.postProcessBeanFactory()");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        System.out.println("Processor2 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

        BeanDefinition bd = registry.getBeanDefinition("student");
        MutablePropertyValues mpv = bd.getPropertyValues();
        mpv.addPropertyValue("username", "hello-world");
    }
}
