package com.watent.source.jdkproxy;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 生成代理类
 *
 * @author Dylan
 * @date 2018/3/19 16:24
 */
public class GeneratorUtil {


    @Test
    public void generate() {
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Subject.class});

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("$Proxy0.class");
            fos.write(data);
            System.out.println(" generate ok ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
