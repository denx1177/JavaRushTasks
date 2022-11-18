package com.javarush.task.pro.task16.task1616;

//import com.sun.source.tree.Tree;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

/* 
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
//        System.out.println(sortedZones);
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        TreeSet<String> availableZones = new TreeSet<>();
        for (var zone : ZoneId.getAvailableZoneIds()){
         availableZones.add(zone);
        }

        return availableZones;
    }

    static ZonedDateTime getBeijingDateTime() {
        ZonedDateTime beijingDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));

        return beijingDateTime;
    }
}
