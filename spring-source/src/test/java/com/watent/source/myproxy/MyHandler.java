package com.watent.source.myproxy;

import java.lang.reflect.Method;

/**
 * InvocationHandler Impl
 *
 * @author Dylan
 * @date 2018/3/23 11:24
 */
public class MyHandler implements MyInvocationHandler {

    private Subject subject;

    public MyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        method.invoke(subject, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("前置通知");
    }

    private void after() {
        System.out.println(" 后置通知 ");
    }

}
