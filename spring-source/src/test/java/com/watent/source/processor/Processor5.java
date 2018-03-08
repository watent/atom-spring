package com.watent.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author Dylan
 * @date 2018/3/7 21:51
 **/
public class Processor5 implements BeanDefinitionRegistryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Processor5 Ordered BeanFactoryPostProcessor.postProcessBeanFactory()");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("Processor5 Ordered BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

        BeanDefinition bd = registry.getBeanDefinition("student");
        MutablePropertyValues mpv = bd.getPropertyValues();
        mpv.addPropertyValue("school", "vip");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
