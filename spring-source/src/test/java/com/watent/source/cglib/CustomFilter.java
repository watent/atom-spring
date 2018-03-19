package com.watent.source.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 自定义过滤器
 *
 * @author Dylan
 * @date 2018/3/19 16:07
 */
public class CustomFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("makeTea".equals(method.getName())) {
            return 0;
        } else if ("makeOrangeJuice".equals(method.getName())) {
            return 1;
        } else if ("makeCoffee".equals(method.getName())) {
            return 2;
        }
        return 0;
    }


}
