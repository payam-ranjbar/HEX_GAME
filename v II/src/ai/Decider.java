package ai;

import entities.Board;
import entities.GamePlay;
import entities.Hexagon;

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
        if (!analyzer.emptyBPoints.isEmpty()) {
            return analyzer.emptyBPoints.get(0);
        } else {
            analyzer.analyzeSameAdjacent(listener.getHex(), listener.getBoard());
            Collections.shuffle(analyzer.sameAdjacent);
            if (!analyzer.sameAdjacent.isEmpty()) {
                analyzer.analyzeEmptyAdjacent(analyzer.sameAdjacent.get(0), listener.getBoard());
            } else {
                analyzer.analyzeEmptyAdjacent(listener.getHex(), listener.getBoard());
            }
            return analyzer.emptyAdjacent.get(0);
        }
    }

}
