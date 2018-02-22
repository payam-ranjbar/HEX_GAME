package ai;

import entities.Board;
import entities.GamePlay;
import entities.Hexagon;
import entities.States;

import java.util.ArrayList;

public class Decider {
    Board board;
    Analyzer analyzer;
    public Decider(GamePlay gamePlay, Analyzer analyzer) {
        board = gamePlay.getBoard();
        this.analyzer = analyzer;
    }
    public Hexagon getBestChoice() {

        return null;
    }

}
