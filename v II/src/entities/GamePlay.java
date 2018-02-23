package entities;

import ai.AI;

public class GamePlay {
    private Player player1;
    private Player player2;
    private GameModes gameMode;
    private GameStates gameState;
    private Board board;
    private int playerTurn = 1;


    public GamePlay(GameModes mode, Board b) {
        //initializing board dimention
        board = b;
        gameState = GameStates.play;

        gameMode = mode;
/*        if(gameMode == GameModes.PersonVsPerson) {
            player1 = new Person(Identity.bluePerson, 1);
            player2 = new Person(Identity.redPerson, 2);
        } else if(gameMode == GameModes.PersonVsAI) {
            player1 = new Person(Identity.bluePerson, 1);
            player2 = new AI(Identity.redAI, 2);
        } else if(gameMode == GameModes.AIvsPerson) {
            player1 = new AI(Identity.blueAI, 1);
            player2 = new Person(Identity.redPerson, 2);
        } else if(gameMode == GameModes.AIvsAI) {
            player1 = new AI(Identity.blueAI, 1);
            player2 = new AI(Identity.redAI, 2);
        }*/
    }

    public Board getBoard() {
        return board;
    }

    public GameModes getGameMode() {
        return gameMode;
    }


    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
}
