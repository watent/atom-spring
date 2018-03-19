package com.watent.source.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 辅助类 回调
 *
 * @author Dylan
 * @date 2018/3/19 16:01
 */
public class MachineAssist implements MethodInterceptor {

    private void before() {
        System.out.println("咖啡伴侣");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        before();
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    private void after() {
        System.out.println("搅拌一下");
    }


}
