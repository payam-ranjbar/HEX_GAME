package entities;

public class AI extends Player {
    public AI(Identity id , int turn) {
        setIdentity(id);
        setPlayerTurn(turn);
    }
    @Override
    public PlayerMove play() {
        return null;
    }
}
