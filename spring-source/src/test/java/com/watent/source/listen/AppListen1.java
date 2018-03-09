package com.watent.source.listen;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 监听
 *
 * @author Dylan
 * @date 2018/3/8 16:52
 */
public class AppListen1 implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof AppEvent) {

            AppEvent appEvent = (AppEvent) event;

            System.out.println("className:" + this.getClass().getName() + " param:" + appEvent.getParam1());
            System.out.println("className:" + this.getClass().getName() + " param:" + appEvent.getParam2());
            System.out.println("className:" + this.getClass().getName() + " param:" + appEvent.getSource());
        }
    }
}
