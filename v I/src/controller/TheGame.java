package controller;

import entities.GamePlay;
import gui.GameScreen;
import gui.SettingScreen;

public class TheGame {
    private GameScreen gameScreen;
    private GamePlay gamePlay;
    private SettingScreen settingScreen;

    public TheGame(){
        gameInitializer();
        gameStart();
    }


    public void gameInitializer() {


    }
    public void gameStart() {
        settingScreen = new SettingScreen();

    }
}
