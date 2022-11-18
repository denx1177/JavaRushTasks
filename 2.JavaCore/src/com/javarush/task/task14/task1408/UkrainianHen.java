package com.javarush.task.task14.task1408;

class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}