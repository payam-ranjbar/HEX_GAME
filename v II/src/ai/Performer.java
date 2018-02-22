package ai;

import entities.Board;
import entities.GamePlay;
import entities.States;
import gui.GameScreen;

public class Performer {

    private GamePlay gamePlay;
    private GameScreen gameScreen;

    public Performer(GamePlay gp , GameScreen gs){
        gamePlay = gp;
        gameScreen = gs;

    }
    public void setHex(int x, int y, States state){
        gameScreen.setHexagonsState(x, y, state);
        gamePlay.getBoard().hexagons[x][y].setState(state);
    }
}
