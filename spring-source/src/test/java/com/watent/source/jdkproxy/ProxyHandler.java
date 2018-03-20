package com.watent.source.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ProxyHandler
 *
 * @author Dylan
 * @date 2018/3/20 11:50
 */
public class ProxyHandler implements InvocationHandler {

    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备工作之前：");
        Object object=   method.invoke( proxied, args);
        System.out.println("工作已经做完了！");
        return object;
    }
}
