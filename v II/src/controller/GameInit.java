package controller;

import entities.GameModes;
import entities.GamePlay;
import entities.Player;
import gui.GameScreen;
@Deprecated
public class GameInit {
    private GamePlay gamePlay;
    private GameModes gameMode;
    private Player [] players;
    private GameScreen gameScreen;

    public GameInit(GamePlay gp, GameScreen gs) {
        players = new Player[2];
        setGamePlay(gp);
        setGameScreen(gs);
    }

    public void setGamePlay(GamePlay gp) {
        gamePlay = gp;
       // players[0] = gp.getPlayerByTurn(1);
        //players[1] = gp.getPlayerByTurn(2);
        gameMode = gp.getGameMode();
    }

    public void setGameScreen(GameScreen gs) {
        gameScreen = gs;
    }

}
