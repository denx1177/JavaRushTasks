package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] jrQuests = JavarushQuest.values();
        for (JavarushQuest jrq : jrQuests) {
            System.out.println(jrq.ordinal());
        }
    }
}
