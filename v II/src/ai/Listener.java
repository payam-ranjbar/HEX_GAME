package ai;

import entities.Board;
import entities.Hexagon;

import java.util.ArrayList;

public class Listener {
    private Hexagon hex;
    private AI ai;
    Board board;
    public Listener(AI ai) {
        this.ai = ai;
    }
    public Hexagon getHex(int x, int y, Board board) {

        return board.hexagons[x][y];
    }
    public void set(Hexagon hex, Board board) {
        this.board = board;
        this.hex =  hex;
    }
    public Hexagon getHex() {
        return hex;
    }

    public Board getBoard() {
        return board;
    }
}
