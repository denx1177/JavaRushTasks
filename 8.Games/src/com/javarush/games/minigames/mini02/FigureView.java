package com.javarush.games.minigames.mini02;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

/* 
Отображаем корабль
*/

public class FigureView extends Game {

    public static final int[][] SHIP = new int[][]{
            {0, 0, 7, 0, 0},
            {0, 7, 7, 7, 0},
            {0, 7, 0, 7, 0},
            {0, 7, 7, 7, 0},
            {0, 7, 0, 7, 0},
            {7, 7, 7, 7, 7},
            {7, 0, 7, 0, 7},
    };

    @Override
    public void initialize()  {
//        super.initialize(); ---  из-за этой строчки не проходило проверку
        setScreenSize(5, 7);
        showShip();
//        showGrid(false);
//        try {
//            Thread.sleep(7000);
//        }catch (Exception ex){        }
//        showGrid(true);
    }

    public void showShip() {
        for (int i = 0; i < SHIP.length; i++) {
            for (int j = 0; j < SHIP[0].length; j++) {
                setCellColor(j, i, Color.values()[SHIP[i][j]]);
            }
        }
    }
}
