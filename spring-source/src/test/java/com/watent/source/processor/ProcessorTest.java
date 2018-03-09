package com.watent.source.processor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 不同接口的优先级顺序
 * PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()
 *
 * @author Dylan
 * @date 2018/3/7 22:12
 * @see org.springframework.context.support.PostProcessorRegistrationDelegate
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProcessorTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void mTest1() {

        Student student = (Student) applicationContext.getBean("student");

        System.out.println("\nstudent:" + student);

        System.out.println("mTest1 complete");
    }


}
