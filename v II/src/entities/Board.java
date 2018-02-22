package entities;
import entities.Attributes;
import entities.Hexagon;
import entities.States;

import java.util.ArrayList;
import java.util.Stack;

public class Board extends Hexagon {
    public Hexagon [][] hexagons;
    private int dimension = 8;
    public ArrayList<Hexagon> foolishZoneList;
    public ArrayList<Hexagon> upSideList;
    public ArrayList<Hexagon> downSideList;
    public ArrayList<Hexagon> criticalZoneList;
    public Board(int d) {
        foolishZoneList = new ArrayList<>();
        upSideList = new ArrayList<>();
        downSideList = new ArrayList<>();
        criticalZoneList = new ArrayList<>();
        dimension = d;
        hexagons = new Hexagon[dimension][dimension];

        // setting positions
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                hexagons[i][j] = new Hexagon(i, j);
            }
        }
        for (int i = 0; i < dimension; i++) {
            for (int j = i + 1; j < dimension; j++) {
                hexagons[i][j].setPosition(Positions.downSide);
                downSideList.add(hexagons[i][j]);
            }
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (hexagons[i][j].getPosition() != Positions.downSide)
                if (i == j) {
                    hexagons[i][j].setPosition(Positions.middle);

                } else {
                    hexagons[i][j].setPosition(Positions.upSide);
                    upSideList.add(hexagons[i][j]);
                }
                if (i == j) {
                    hexagons[i][j].setLocation(Locations.criticalZone);
                    criticalZoneList.add(hexagons[i][j]);
                } else if ( (j==0 && i>=4) || (j == 1 && i >= 5) || (j == 2 && i >= 6) || (j == 3 && i == 7)
                        || (i==0 && j>=4) || (i == 1 && j >= 5) || (i == 2 && j >= 6) || (i == 3 && j == 7) ){
                    hexagons[i][j].setLocation(Locations.foolishZone);
                    foolishZoneList.add(hexagons[i][j]);
                } else {
                    hexagons[i][j].setLocation(Locations.dangerZone);

                }


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

