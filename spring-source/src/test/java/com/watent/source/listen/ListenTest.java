package com.watent.source.listen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SimpleApplicationEventMulticaster.multicastEvent()
 * 多路广播
 *
 * @author Dylan
 * @date 2018/3/7 22:12
 * @see org.springframework.context.event.SimpleApplicationEventMulticaster
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ListenTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void test1() {
        System.out.println("\n*** ListenTest ***");
        AppEvent event = new AppEvent("source", "param1", "param2");
        applicationContext.publishEvent(event);
    }

}
