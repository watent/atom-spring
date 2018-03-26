package com.watent.source.myproxy;

import java.io.*;

/**
 * 自定义类加载器
 *
 * @author Dylan
 * @date 2018/3/25 13:39
 */
public class MyClassLoader extends ClassLoader {

    private File dir;

    public MyClassLoader(String path) {
        this.dir = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if (null != dir) {
            File classFile = new File(dir, name + ".class");
            if (classFile.exists()) {

                try {
                    FileInputStream fis = new FileInputStream(classFile);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int len;
                    byte[] buffer = new byte[1024];
                    while ((len = fis.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);
                    }
                    //创建一个实例
                    return defineClass("com.watent.source.myproxy." + name, baos.toByteArray(), 0, baos.size());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        return super.findClass(name);

    }
}
