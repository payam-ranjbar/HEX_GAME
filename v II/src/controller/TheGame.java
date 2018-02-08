package controller;

import entities.Board;
import entities.GamePlay;
import gui.GameScreen;
import gui.SettingScreen;

public class TheGame {
    private GameScreen gameScreen;
    private GamePlay gamePlay;
    private Board board;
    private SettingScreen settingScreen;

    public TheGame(){
        gameInitializer();
        gameStart();
    }


    public void gameInitializer() {
        board = new Board(8);
    }
    public void gameStart() {
        settingScreen = new SettingScreen(board);

    }

    public Board getBoard() {
        return board;
    }
}
