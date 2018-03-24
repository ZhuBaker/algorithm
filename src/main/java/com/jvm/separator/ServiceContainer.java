package com.jvm.separator;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 服务容器，用于装载，启动目录服务
 * User: zhubo
 * Date: 2018-03-24
 * Time: 14:52
 */
public class ServiceContainer {
    //ServiceClassLoader 默认加载路径
    private static final String DEFAULT_SERVICE_PATH = "META-INF/service";

    //策略模式
    private static SpringClassLoader springClassLoader;

    /**
     * ClassLoader装配和初始化工作, SpringClassLoader 和 ServiceClassLoader进行隔离,
     * 如果SpringClassLoader加载不到的类 到 ServiceClassLoader中进行加载,这样既保证了两个“类库”隔离的效果，保证了 两个 “类库” 中类的相对加载顺序
     */
    public static void start(){
        start(DEFAULT_SERVICE_PATH);
    }

    public static void start (String serviceDir) {
        ClassLoader parent = ServiceContainer.class.getClassLoader();
        ServiceClassLoader serviceClassLoader = new ServiceClassLoader(parseServiceDir(serviceDir), parent);
        springClassLoader = new SpringClassLoader();
        springClassLoader.setServiceClassLoader(serviceClassLoader);
        //设置当前环境默认的类加载器为SpringClassLoader类加载器 （这个类确保两个隔离环境 类的加载顺序）
        Thread.currentThread().setContextClassLoader(springClassLoader);
    }

    //工厂模式
    private static URL[] parseServiceDir(String serviceDir) {
        try {
            URL url = ServiceContainer.class.getClassLoader().getResource(serviceDir);
            if (url != null) {
                serviceDir = url.getPath();
            }
            List<java.net.URL> urlList = new ArrayList<java.net.URL>();
            File dir = new File(serviceDir);
            if (!dir.isDirectory()) {
                throw new IllegalStateException(dir.getPath() + " is not dir");
            }
            for (File file : dir.listFiles()) {
                if (file.getPath().endsWith(".jar")) {
                    urlList.add(new URL("file:" + file.getPath()));
                }
            }
            if (urlList.isEmpty()) {
                throw new IllegalStateException("urlList is empty");
            }
            return urlList.toArray(new java.net.URL[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Class<?> loadClass(String name) throws ClassNotFoundException {
        return springClassLoader.loadClass(name);
    }

}
