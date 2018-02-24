package ai;

import entities.*;
import gui.GameScreen;

import java.util.Collections;


public class AI {
    private int turn;
    private States color;
    private Analyzer analyzer;
    private Decider decider;
    private Listener listener;
    private Performer performer;
    private Board board;
    private GameScreen gui;

   public AI (int turn , States state, GamePlay gp, GameScreen gui) {
        color = state;
        this.turn = turn;
        analyzer = new Analyzer();
        listener = new Listener(this);
        decider = new Decider(gp, analyzer, listener);
        board = gp.getBoard();
        performer = new Performer(gp,gui);
    }

    public int [] beginGame() {
        Collections.shuffle(board.foolishZoneList);
        Hexagon temp = board.foolishZoneList.get(0);

        for (int i = 0; i < board.foolishZoneList.size(); i++ ) {
            if ( board.foolishZoneList.get(i).getState() == States.empty) {
                temp = board.foolishZoneList.get(i);
                break;
            }
        }
        int x = temp.getX();
        int y = temp.getY();
        performer.setHex(x, y, color);
        int [] result = new int [2];
        result[0] = x;
        result[1] = y;
        return result;

    }
    public int [] play() {
       Hexagon temp = decider.getBestChoice();
       int x = temp.getX();
       int y = temp.getY();
       performer.setHex(x, y, color);
       int [] result = new int [2];
       result[0] = x;
       result[1] = y;
       return result;

    }
    public Listener getListener(){
       return listener;
    }

    public Decider getDecider() {
        return decider;
    }
}
