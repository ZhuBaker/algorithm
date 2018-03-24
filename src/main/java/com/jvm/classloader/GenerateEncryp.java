package com.jvm.classloader;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 加解密工具类 及 生成加密文件
 * User: zhubo
 * Date: 2018-03-24
 * Time: 10:25
 */
public class GenerateEncryp {

    public static void cypher(InputStream ips , OutputStream ops) throws IOException {
        int b = -1;
        while((b = ips.read()) != -1){
            ops.write(b ^ 0xff);
        }
    }
    public static void uncypher(InputStream ips , OutputStream ops) throws IOException {
        int b = -1;
        while((b = ips.read()) != -1){
            ops.write(b&0xff );
        }
    }

    /**
     * 现在要调用加密的类，对某个class文件进行加密.
     * 那么要传递一个要加密文件及路径，和要保存加密文件的路径
     * @param args
     */
    public static void main(String[] args) throws IOException{

        // 源文件路径
        String srcPath = "D:\\workspace\\quartz_dir\\algorithm\\target\\classes\\com\\jvm\\classloader\\ClassLoaderAttachment.class";
        // 目标文件的目录
        String descDir = "D:\\workspace";
        // 目标文件名称
        String descFileName = srcPath.substring(srcPath.lastIndexOf("\\"));
        String descPath = descDir + descFileName;
        FileInputStream fis = new FileInputStream(srcPath);
        FileOutputStream fos = new FileOutputStream(descPath);
        cypher(fis,fos);
        fis.close();
        fos.close();

    }

}
