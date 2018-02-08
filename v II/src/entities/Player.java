package entities;

public abstract class Player {
    private Identity identity;
    //1 for first player 2 for second player
    private int playerTurn;

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Identity getIdentity() {
        return identity;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public abstract PlayerMove play();

}
