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
                // pushing the allies to stack
                // i constant
                if ( !((j+1) > dimension - 1 ) ) {
                    hexagons[i][j].allies.push(hexagons[i][j]);
                }
                if ( !((j-1) < 0) ) {
                    hexagons[i][j].allies.push(hexagons[i][j-1]);
                }
                //j constant
                if ( !((i+1) > dimension - 1 ) ) {
                    hexagons[i][j].allies.push(hexagons[i+1][j]);
                }
                if ( !((i-1) < 0) ) {
                    hexagons[i][j].allies.push(hexagons[i-1][j]);
                }
                // i-1 j-1
                if ( (!((j-1) < 0)) && !((i-1) < 0 ) ) {
                    hexagons[i][j].allies.push(hexagons[i-1][j-1]);
                }
                //i+1 j+1
                if ( (!((j+1) > dimension - 1)) && !((i+1) > dimension - 1) ) {
                    hexagons[i][j].allies.push(hexagons[i+1][j+1]);
                }            }
        }
    }

    public void checkForWin() {

    }
    public void setState(int x, int y, States state) {
        hexagons[x][y].setState(state);
    }


}

