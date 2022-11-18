package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
