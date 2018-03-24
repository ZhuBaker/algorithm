package com.jvm.classloader;

/**
 * Created with IntelliJ IDEA.
 * Description: 编解码调度类
 * User: zhubo
 * Date: 2018-03-24
 * Time: 10:17
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        DecodeClassLoader dcl = new DecodeClassLoader("D:\\workspace");
        Class<?> aClass = dcl.loadClass("ClassLoaderAttachment.class");
        Object o = aClass.newInstance();
        System.out.println(o.getClass().getName());
        System.out.println(o.getClass().getClassLoader());
        aClass.getMethod("say",null).invoke(o,null);

    }

}
