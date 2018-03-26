package com.watent.source.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义代理
 *
 * @author Dylan
 * @date 2018/3/23 11:23
 */
public class MyProxy {

    private static final String RT = "\r\n";

    public static Object createProxyInstance(ClassLoader loader, Class intf, MyInvocationHandler handler) {

        //1.生成内存中代理类 字符串拼接$proxy0.java 文件
        String proxyClass = gerProxyStr(intf);
        //2.写入磁盘
//        String fileName = "/Users/ytx/ws-sys/atom-spring/spring-source/$proxy0.java";
        String fileName = "/Users/ytx/ws-sys/atom-spring/spring-source/src/test/java/com/watent/source/myproxy/$Proxy0.java";
        File file = new File(fileName);
        FileWriter fw;
        try {
            fw = new FileWriter(file);
            fw.write(proxyClass);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.编译文件 $proxy0.java
        compileJava(fileName);

        //4. 通过自定义类加载器把编译的 .class 文件加载到内存中
        String path = "/Users/ytx/ws-sys/atom-spring/spring-source/src/test/java/com/watent/source/myproxy/";
//        String path = "/Users/ytx/ws-sys/atom-spring/spring-source/src/test/java/com/watent/source/myproxy";
        MyClassLoader classLoader = new MyClassLoader(path);
        try {
            Class<?> proxy0class = classLoader.findClass("$Proxy0");
            // proxy0class.newInstance()  无参数
            Constructor constructor = proxy0class.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(handler);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void compileJava(String fileName) {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
        t.call();
        try {
            fileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String gerProxyStr(Class intf) {

        //拼接代理生成类
        Method[] methods = intf.getMethods();

        String proxyClassStr = "package com.watent.source.myproxy; " + RT
                + "import java.lang.reflect.Method;" + RT
                + "public class $Proxy0 implements " + intf.getName() + "{" + RT
                + "MyInvocationHandler h;" + RT
                + "public $Proxy0(MyInvocationHandler h){" + RT
                + "this.h = h;" + RT
                + "}" + RT
                + getMethodStr(methods, intf) + RT
                + "}";
        return proxyClassStr;
    }

    private static String getMethodStr(Method[] methods, Class intf) {

        StringBuilder proxyMethod = new StringBuilder();
        for (Method m : methods) {
            proxyMethod.append("public void ").append(m.getName()).append("() throws Throwable {").append(RT)
                    .append("Method md = ").append(intf.getName()).append(".class.getMethod(\"").append(m.getName()).append("\",new Class[]{});").append(RT)
                    .append("this.h.invoke(this,md,null);").append(RT)
                    .append("}").append(RT);
        }
        return proxyMethod.toString();
    }

}
