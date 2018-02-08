package entities;

import entities.*;

public class GamePlay {
    private Player player1;
    private Player player2;
    private GameModes gameMode;
    private GameStates gameState;
    private Board board = new Board(8);
    private int playerTurn = 1;


    public GamePlay(GameModes mode) {
        //initializing board dimention
        ;

        gameState = GameStates.play;

        gameMode = mode;
        if(gameMode == GameModes.PersonVsPerson) {
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
        }
    }

    public Board getBoard() {
        return board;
    }

    public GameModes getGameMode() {
        return gameMode;
    }
    public Player getPlayerByTurn(int t) {
        if(player1.getPlayerTurn() == t) {
            return player1;
        }
        return player2;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }
}
