package com.watent.source.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * @author Dylan
 * @date 2018/3/7 21:51
 **/
public class Processor3 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("Processor3 PriorityOrdered BeanFactoryPostProcessor.postProcessBeanFactory()");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("Processor3 PriorityOrdered BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
