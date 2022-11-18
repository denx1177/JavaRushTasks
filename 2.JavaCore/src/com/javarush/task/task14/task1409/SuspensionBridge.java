package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge{
    private static final int COUNT = 5;
    @Override
    public int getCarsCount(){
        return COUNT;
    }
}
