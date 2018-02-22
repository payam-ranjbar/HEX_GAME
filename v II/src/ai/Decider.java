package ai;

import entities.Board;
import entities.GamePlay;
import entities.Hexagon;
import entities.States;

import java.util.ArrayList;

public class Decider {
    private Board board;
    private Analyzer analyzer;
    private Listener listener;
    public Decider(GamePlay gamePlay, Analyzer analyzer, Listener listener) {
        board = gamePlay.getBoard();
        this.analyzer = analyzer;
    }
    public Hexagon getBestChoice() {
        return null;
    }

}
