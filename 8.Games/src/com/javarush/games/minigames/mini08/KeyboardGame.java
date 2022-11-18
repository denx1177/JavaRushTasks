package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.*;

/* 
Работа с клавиатурой
*/

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }

    //напишите тут ваш код
    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                for (int i = 0; i < 3; i++) {
                    setCellColor(0, i, Color.GREEN);
                }
                break;
            case RIGHT:
                for (int i = 0; i < 3; i++) {
                    setCellColor(2, i, Color.GREEN);
                }
                break;
            case UP:
                for (int i = 0; i < 3; i++) {
                    setCellColor(i,0, Color.GREEN);
                }
                break;
            case DOWN:
                for (int i = 0; i < 3; i++) {
                    setCellColor(i,2,Color.GREEN);
                }
        }
    }
    @Override
    public void onKeyReleased(Key key){
        switch (key) {
            case LEFT:
                for (int i = 0; i < 3; i++) {
                    setCellColor(0, i, Color.WHITE);
                }
                break;
            case RIGHT:
                for (int i = 0; i < 3; i++) {
                    setCellColor(2, i, Color.WHITE);
                }
                break;
            case UP:
                for (int i = 0; i < 3; i++) {
                    setCellColor(i,0, Color.WHITE);
                }
                break;
            case DOWN:
                for (int i = 0; i < 3; i++) {
                    setCellColor(i,2,Color.WHITE);
                }
        }
    }
}
