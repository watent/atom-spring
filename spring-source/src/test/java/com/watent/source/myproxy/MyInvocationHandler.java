package com.watent.source.myproxy;

import java.lang.reflect.Method;

/**
 * 自定义 InvocationHandler
 *
 * @author Dylan
 * @date 2018/3/23 11:22
 */
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
