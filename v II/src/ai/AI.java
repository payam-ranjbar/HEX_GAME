package ai;

import entities.Identity;
import entities.Player;
import entities.PlayerMove;

public class AI extends Player {
    public AI(Identity id , int turn) {
        setIdentity(id);
        setPlayerTurn(turn);
    }
    @Override
    public PlayerMove play() {
        return null;
    }
    public void perform(){

    }
}
