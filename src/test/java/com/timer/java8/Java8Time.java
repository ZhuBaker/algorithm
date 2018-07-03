package com.timer.java8;

import java.time.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description:
 * @time: 2018年07月03日
 * @modifytime:
 */
public class Java8Time {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant表示：\t\t\t\t" + instant);
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate表示：\t\t\t\t" + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime表示：\t\t\t\t" + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime表示：\t\t\t\t" + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime表示：\t\t\t\t" + zonedDateTime);

    }
}
