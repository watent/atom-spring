package com.watent.source.cglib;

import org.springframework.cglib.proxy.FixedValue;

/**
 * 固定值
 *
 * @author Dylan
 * @date 2018/3/19 16:15
 */
public class FixValueCallback implements FixedValue {

    @Override
    public Object loadObject() throws Exception {
        System.out.println("invoke fixedValue");
        return 123;
    }
}
