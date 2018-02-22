package ai;

import entities.Board;
import entities.Hexagon;
import entities.States;

import java.util.ArrayList;

public class Decider {
    ArrayList<Hexagon> emptyBPoints;

    public void getEmptyBPoints(Hexagon hex, Board board) {
        int x = hex.getX();
        int y = hex.getY();

        if ((x - 1) >= 0 && (y - 2) >= 0) {
            if (board.hexagons[x - 1][y - 2].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x - 1][y - 2]);
            }
        }
        if ((x + 1) <= 7 && (y - 1) >= 0) {
            if (board.hexagons[x + 1][y - 1].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x + 1][y - 1]);
            }
        }
        if ((x - 2) >= 0 && (y - 1) >= 0) {
            if (board.hexagons[x - 2][y - 1].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x - 2][y - 1]);
            }
        }

        if ((x - 1) >= 0 && (y + 1) <= 7) {
            if (board.hexagons[x - 1][y + 1].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x - 1][y + 1]);
            }
        }

        if ((x + 2) <= 7 && (y + 1) <= 7) {
            if (board.hexagons[x + 2][y + 1].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x + 2][y + 1]);
            }
        }

        if ((x - 1) >= 0 && (y + 2) <= 7) {
            if (board.hexagons[x - 1][y + 2].getState() == States.empty) {
                emptyBPoints.add(board.hexagons[x - 1][y + 2]);
            }
        }
    }

}
