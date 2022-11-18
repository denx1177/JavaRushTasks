package com.javarush.task.pro.task16.task1618;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* 
Лишь бы не запутаться
*/

public class Solution {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
//        ZoneId zone3 = ZoneId.of("Asia/Shanghai");
//        ZoneId zone4 = ZoneId.of("GMT");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));
//        System.out.println(ZonedDateTime.now(zone3));
//        System.out.println(ZonedDateTime.now(zone4));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromDateTime, ZoneId fromZone, ZoneId toZone) {
        //напишите тут ваш код
        ZonedDateTime fromZoneDateTime = ZonedDateTime.of(fromDateTime,fromZone);
//        System.out.println(fromZoneDateTime);
        ZonedDateTime toZoneDateTime = fromZoneDateTime.withZoneSameInstant(toZone);
//        System.out.println(toZoneDateTime);
        return toZoneDateTime.toLocalDateTime();
    }
}
