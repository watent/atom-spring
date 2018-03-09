package com.watent.source.listen;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author Dylan
 * @date 2018/3/8 16:53
 */
public class AppEvent extends ApplicationEvent {

    public String param1;

    public String param2;

    public AppEvent(Object source, String param1, String param2) {
        super(source);          //must
        this.param1 = param1;
        this.param2 = param2;
    }

    public Object getSource() {
        return super.source;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
