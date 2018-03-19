package com.watent.source.aop;

/**
 * IntroductionInt Impl
 *
 * @author Dylan
 * @date 2018/3/19 15:06
 */
public class IntroductionIntImpl implements IntroductionInt {

    @Override
    public void extend() {
        System.out.println("我是切面Introduction引入的方法");
    }
}
