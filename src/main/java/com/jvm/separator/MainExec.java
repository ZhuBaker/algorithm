package com.jvm.separator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description: 入口主函数
 * User: zhubo
 * Date: 2018-03-24
 * Time: 14:47
 */
public class MainExec {
    public static void main(String[] args) throws Exception{

        String startClass = "org.springframework.context.support.ClassPathXmlApplicationContext";
        // 任意绝对路径
        //ServiceContainer.start("C:/services");
        ServiceContainer.start();
        Class<?> aClass = ServiceContainer.loadClass(startClass);
        ClassPathXmlApplicationContext ctx =
                (ClassPathXmlApplicationContext) aClass.getConstructor(new Class<?>[]{String.class}).newInstance(new Object[]{"beans.xml"});
        Object obj = ctx.getBean("helloService");
        System.out.println(obj);

        Method method = obj.getClass().getDeclaredMethod("sayHello", new Class[]{String.class});
        method.invoke(obj,"hello");

    }
}
