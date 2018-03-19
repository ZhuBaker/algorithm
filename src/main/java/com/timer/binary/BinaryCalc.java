package com.timer.binary;

import org.junit.Test;

/**
 * Created by zhubo on 2018/3/18.
 */
public class BinaryCalc {

    public static void main(String[] args) {
        int i = 2 ^ 2 ^ 2 ;
        System.out.println(i);
    }


    /**
     * 负数二进制
     */
    @Test
    public void intByN(){
        int i = -10;   //"...1111110110"
        String binaryStr = Integer.toBinaryString(i);
        System.out.println(binaryStr);

        int j = 10; //"...0001010"  --> "...111110101"  --> "...111110110"
        String binaryStr2 = Integer.toBinaryString(j);
        System.out.println(binaryStr2);
    }




    /**
     * 十进制转二进制字符串
     */
    @Test
    public void intToBinaryStr(){
        String str = Integer.toBinaryString(10);
        System.out.println(str);
    }


    /**
     * 二进制字符串转十进制数
     */
    @Test
    public void binaryStrToInt(){
        int i = Integer.valueOf("1010", 2).intValue();
        System.out.println(i);
    }


    /**
     * 二进制异或操作
     * 两个相应的为不同，则该位结果为1，否则为0
     */
    @Test
    public void binaryCalc1(){
        int i = Integer.valueOf("010101", 2).intValue();
        int j = Integer.valueOf("101010", 2).intValue();

        int a = i ^ j;
        System.out.println(a);
    }


    /**
     * 按位取反运算
     */
    @Test
    public void binaryF(){
        int i = Integer.valueOf("010101", 2).intValue();
        System.out.println(i);
        int j = ~i;
        String jStr = Integer.toBinaryString(j);
        System.out.println(jStr);
    }


    /**
     * 左移若干位
     * 将各二进制位全部左移若干位（左边的二进制丢弃，右边补0）
     * 若左移时舍弃的高位不包含1，则每左移一位，相当于该数乘2
     */
    @Test
    public void binaryLeftMove(){
        int i = -20;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        int j = -20 << 1;
        System.out.println(j);
    }






}
