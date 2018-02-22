package ai;

import entities.Identity;
import entities.Player;
import entities.PlayerMove;
import entities.States;

public class AI {
    private int turn;
    private States color;
    private Analyzer analyzer;
    private Decider decider;
    private Listener listener;
    private Performer performer;
    private MoveTracker moveTracker;
    private Valuer valuer;

   public AI (int turn , States state) {
        color = state;
        this.turn = turn;
    }

    public void beginGame() {

    }
    public void play() {

    }
    public Listener getListener(){
       return listener;
    }

}
