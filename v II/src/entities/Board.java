package entities;
import entities.Attributes;
import entities.Hexagon;
import entities.States;

import java.util.Stack;

public class Board extends Hexagon {
    public Hexagon [][] hexagons;
    private int dimension = 8;

    public Board(int d) {
        dimension = d;
        hexagons = new Hexagon[dimension][dimension];

        // setting positions
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                hexagons[i][j] = new Hexagon(i, j);
            }
        }
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                // setting Attributes
                if (i == 0 || i == dimension - 1) {
                    hexagons[i][j].setAttribute(Attributes.blueSide);
                }
                if (j == 0 || j == dimension - 1) {
                    hexagons[i][j].setAttribute(Attributes.redSide);
                }
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setState(int x, int y, States state) {
        hexagons[x][y].setState(state);
    }


}

