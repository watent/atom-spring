package com.watent.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author Dylan
 * @date 2018/3/7 21:51
 **/
public class Processor6 implements BeanDefinitionRegistryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Processor6 Ordered BeanFactoryPostProcessor.BeanFactoryPostProcessor()");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("Processor6 Ordered BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");

//        BeanDefinition bd = registry.getBeanDefinition("jackstudent");
//        MutablePropertyValues mpv = bd.getPropertyValues();
//        
//        mpv.addPropertyValue("school", "dongnao");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
