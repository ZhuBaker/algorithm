package com.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhubo
 * Date: 2018-03-24
 * Time: 9:40
 */
public class DecodeClassLoader extends ClassLoader {

    private String pathDir;

    public DecodeClassLoader(String pathDir) {
        this.pathDir = pathDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileName = pathDir + "\\" + name.substring(0,name.lastIndexOf(".")) + ".class";
        System.out.println(classFileName);
        try{
            FileInputStream fis = new FileInputStream(classFileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GenerateEncryp.cypher(fis,bos);
            //GenerateEncryp.uncypher(fis,bos);
            fis.close();
            byte[] bytes = bos.toByteArray();
            return defineClass(null,bytes,0,bytes.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
