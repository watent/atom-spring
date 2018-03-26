package com.watent.source.myproxy;

/**
 * RealSubject
 *
 * @author Dylan
 * @date 2018/3/20 11:49
 */
public class RealSubject implements Subject {

    @Override
    public void subjectShow() {
        System.out.println("真实主题！" + getClass());
    }
}
