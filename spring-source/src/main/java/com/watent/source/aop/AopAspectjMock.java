package com.watent.source.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AopAspectj 模拟
 *
 * @author Dylan
 * @date 2018/3/19 15:11
 */
public class AopAspectjMock {

    public void before() {
        System.out.println("*** 前置通知 ***");
    }

    public void after() {
        System.out.println("*** 后置通知 ***");
    }

    public void afterReturning() {
        System.out.println("*** 返回后通知 ***");
    }

    public void afterthrowing() {
        System.out.println("*** 跑出后通知 ***");
    }

    public void around(ProceedingJoinPoint point) {
        System.out.println("*** 前置环绕通知 ***");
        try {
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("*** 后置环绕通知 ***");
    }
}
