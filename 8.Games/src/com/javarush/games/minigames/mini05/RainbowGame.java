package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    //напишите тут ваш код
    @Override
    public void initialize() {
        setScreenSize(10, 7);
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 10; i++) {
                setCellColor(i, j, colors[j]);
            }
        }
    }
}
