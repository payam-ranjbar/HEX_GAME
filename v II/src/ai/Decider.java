package ai;

import entities.Board;
import entities.GamePlay;
import entities.Hexagon;
import entities.States;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Decider {
    private Board board;
    private Analyzer analyzer;
    private Listener listener;
    public Decider(GamePlay gamePlay, Analyzer analyzer, Listener listener) {
        board = gamePlay.getBoard();
        this.analyzer = analyzer;
        this.listener = listener;

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Hexagon getBestChoice() {
        if (listener == null) {
            System.out.println("ok stupid");
        }
        analyzer.analyze(listener.getHex(),listener.board);
        analyzer.analyzeEmptyBPoints(listener.getHex(), listener.board);
        Random rnd = new Random();
        Collections.shuffle(analyzer.emptyBPoints);
        return analyzer.emptyBPoints.get(0);
    }

}
