package com.timer.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description: 日期格式化 及 string LocalDateTime的转换
 * @time: 2018年07月03日
 * @modifytime:
 */
public class FormatTime {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = formatter.format(localDateTime);
        String format1 = localDateTime.format(formatter);
        System.out.println(format);
        System.out.println(format1);
        LocalDateTime parse = LocalDateTime.parse(format, formatter);
        System.out.println(parse);
    }
}
