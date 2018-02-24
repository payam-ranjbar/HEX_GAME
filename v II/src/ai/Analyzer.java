package ai;

import entities.*;

import java.util.ArrayList;

public class Analyzer {
    ArrayList<Hexagon> emptyBPoints;
    ArrayList<Hexagon> sameAdjacent;
    ArrayList<Hexagon> emptyAdjacent;
    ArrayList<Hexagon> oppositeBPoints;
    ArrayList<Hexagon> sameBPoints;
    public Analyzer() {
        emptyBPoints = new ArrayList<>();
        emptyAdjacent = new ArrayList<>();
    }

    public void analyze(Hexagon hex, Board board){
        getEmptyBPoints(hex, board);
      //  getOppositeBPoints(hex, board);
       // getSameBPoints(hex, board);
    }

    public void analyzeEmptyBPoints(Hexagon hex, Board board) {

        int x = hex.getX();
        int y = hex.getY();
        boolean isUpside = hex.getPosition() == Positions.upSide;
        for (int i = 0; i < emptyBPoints.size(); i++){
            if ( emptyBPoints.get(i).getLocation() != Locations.foolishZone) {
                emptyBPoints.remove(i);
            }
        }

        if (isUpside) {
            for (int i = 0; i < emptyBPoints.size(); i++){
                Hexagon temp = emptyBPoints.get(i);
                if (hex.getState() == States.blue) {
                    if (temp.getX() == x + 1 && temp.getY() == y - 1) {
                        emptyBPoints.remove(i);
                    }
                    if (temp.getX() == x - 1 && temp.getY() == y - 2) {
                        emptyBPoints.remove(i);
                    }
                    if (temp.getX() == x + 2 && temp.getY() == y + 1) {
                        emptyBPoints.remove(i);
                    }
                } else if (hex.getState() == States.red) {
                    if (temp.getX() == x + 1 && temp.getY() == y - 1) {
                        emptyBPoints.remove(i);
                    }
                    if (temp.getX() == x + 2 && temp.getY() == y + 1) {
                        emptyBPoints.remove(i);
                    }
                }

            }
        } else if (hex.getState() == States.red) {
            for (int i = 0; i < emptyBPoints.size(); i++){
                Hexagon temp = emptyBPoints.get(i);
                if (temp.getX() == x - 1 && temp.getY() == y + 1) {
                    emptyBPoints.remove(i);
                }
                if (temp.getX() == x - 2 && temp.getY() == y - 1) {
                    emptyBPoints.remove(i);
                }
                if (temp.getX() == x + 1 && temp.getY() == y + 1) {
                    emptyBPoints.remove(i);
                }

            }

        }


    }

    public ArrayList<Hexagon> getEmptyBPoints(Hexagon hex, Board board) {
        emptyBPoints = new ArrayList<>();
        int x = hex.getX();
        int y = hex.getY();

        if ((x - 1) >= 0 && (y - 2) >= 0) {
        //    System.out.println("bug is here: " + board.hexagons[x - 1][y - 2]);
            System.out.println("what X is: " + x);
            //System.out.println("what X-1 is: " + --x);
            System.out.println("what Y is: " + y);
         //   System.out.println("what Y-2 is: " + y-=2 );
            if (board.hexagons[x - 1][y - 2].getState() == States.empty) {
                System.out.println("bridge1 detected: " + board.hexagons[x - 1][y - 2]);
                if (board.hexagons[x - 1][y - 2] == null) {
                    System.out.println("hey stupid");
                }
                emptyBPoints.add(board.hexagons[x - 1][y - 2]);
            }
        }
        if ((x + 1) <= 7 && (y - 1) >= 0) {
            if (board.hexagons[x + 1][y - 1].getState() == States.empty) {
                System.out.println("bridge2 detected: " + board.hexagons[x + 1][y - 1]);
                emptyBPoints.add(board.hexagons[x + 1][y - 1]);
            }
        }
        if ((x - 2) >= 0 && (y - 1) >= 0) {
            if (board.hexagons[x - 2][y - 1].getState() == States.empty) {
                System.out.println("bridge3 detected: " + board.hexagons[x - 2][y - 1]);

                emptyBPoints.add(board.hexagons[x - 2][y - 1]);
            }
        }

        if ((x - 1) >= 0 && (y + 1) <= 7) {
            if (board.hexagons[x - 1][y + 1].getState() == States.empty) {
                System.out.println("bridge4 detected: " + board.hexagons[x - 1][y + 1]);
                emptyBPoints.add(board.hexagons[x - 1][y + 1]);
            }
        }

        if ((x + 2) <= 7 && (y + 1) <= 7) {
            if (board.hexagons[x + 2][y + 1].getState() == States.empty) {
                System.out.println("bridge5 detected: " + board.hexagons[x + 2][y + 1]);
                emptyBPoints.add(board.hexagons[x + 2][y + 1]);

            }
        }

        if ((x - 1) >= 0 && (y + 2) <= 7) {
            if (board.hexagons[x - 1][y + 2].getState() == States.empty) {
                System.out.println("bridge6 detected: " + board.hexagons[x - 1][y + 2]);

                emptyBPoints.add(board.hexagons[x - 1][y + 2]);
            }
        }


        return emptyBPoints;
    }

    public ArrayList<Hexagon> getOppositeBPoints(Hexagon hex, Board board) {
        States OppositeState = hex.getState().reverse();
        int x = hex.getX();
        int y = hex.getY();
        oppositeBPoints = new ArrayList<>();
        if ((x - 1) > 0 && (y - 2) > 0) {
            if (board.hexagons[x - 1][y - 2].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x - 1][y - 2]);
            }
        }
        if ((x + 1) < 7 && (y - 1) > 0) {
            if (board.hexagons[x + 1][y - 1].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x + 1][y - 1]);
            }
        }
        if ((x - 2) > 0 && (y - 1) > 0) {
            if (board.hexagons[x - 2][y - 1].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x - 2][y - 1]);
            }
        }

        if ((x - 1) > 0 && (y + 1) < 7) {
            if (board.hexagons[x - 1][y + 1].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x - 1][y + 1]);
            }
        }

        if ((x + 2) < 7 && (y + 1) < 7) {
            if (board.hexagons[x + 2][y + 1].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x + 2][y + 1]);
            }
        }

        if ((x - 1) > 0 && (y + 2) < 7) {
            if (board.hexagons[x - 1][y + 2].getState() == OppositeState) {
                emptyBPoints.add(board.hexagons[x - 1][y + 2]);
            }
        }
        return oppositeBPoints;
    }

    public ArrayList<Hexagon> getSameBPoints(Hexagon hex, Board board) {
        States state = hex.getState();
        int x = hex.getX();
        int y = hex.getY();
        sameBPoints = new ArrayList<>();

        if ((x - 1) >= 0 && (y - 2) >= 0) {
            if (board.hexagons[x - 1][y - 2].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x - 1][y - 2]);
                emptyBPoints.add(board.hexagons[x - 1][y - 2]);
            }
        }
        if ((x + 1) <= 7 && (y - 1) >= 0) {
            if (board.hexagons[x + 1][y - 1].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x + 1][y - 1]);
                emptyBPoints.add(board.hexagons[x + 1][y - 1]);
            }
        }
        if ((x - 2) >= 0 && (y - 1) >= 0) {
            if (board.hexagons[x - 2][y - 1].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x - 2][y - 1]);

                emptyBPoints.add(board.hexagons[x - 2][y - 1]);
            }
        }

        if ((x - 1) >= 0 && (y + 1) <= 7) {
            if (board.hexagons[x - 1][y + 1].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x - 1][y + 1]);
                emptyBPoints.add(board.hexagons[x - 1][y + 1]);
            }
        }

        if ((x + 2) <= 7 && (y + 1) <= 7) {
            if (board.hexagons[x + 2][y + 1].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x + 2][y + 1]);
                emptyBPoints.add(board.hexagons[x + 2][y + 1]);

            }
        }

        if ((x - 1) >= 0 && (y + 2) <= 7) {
            if (board.hexagons[x - 1][y + 2].getState() == state) {
                System.out.println("bridge detected: " + board.hexagons[x - 1][y + 2]);

                emptyBPoints.add(board.hexagons[x - 1][y + 2]);
            }
        }
        return sameBPoints;
    }


    public ArrayList<Hexagon> analyzeSameAdjacent(Hexagon hex, Board board) {
        int i = hex.getX();
        int j = hex.getY();
        sameAdjacent = new ArrayList<>();
        //int dimension = board.getDimension();
        int dimension = 8;

        // i constant
        if ( !((j+1) > dimension - 1 ) ) {
            if(board.hexagons[i][j+1].getState() == hex.getState()) {
                sameAdjacent.add(board.hexagons[i][j+1]);
            }
        }
        if ( !((j-1) < 0) ) {
            if(board.hexagons[i][j-1].getState() == hex.getState()) {
        sameAdjacent.add(board.hexagons[i][j-1]);
    }
}
//j constant
        if ( !((i+1) > dimension - 1 ) ) {
                if(board.hexagons[i+1][j].getState() == hex.getState()) {
                sameAdjacent.add(board.hexagons[i+1][j]);
                }
                }
                if ( !((i-1) < 0) ) {
        if(board.hexagons[i-1][j].getState() == hex.getState()) {
        sameAdjacent.add(board.hexagons[i-1][j]);
        }
        }
        // i-1 j-1
        if ( (!((j-1) < 0)) && !((i-1) < 0 ) ) {
        if(board.hexagons[i-1][j-1].getState() == hex.getState()) {
        sameAdjacent.add(board.hexagons[i-1][j-1]);

        }
        }
        //i+1 j+1
        if ( (!((j+1) > dimension - 1)) && !((i+1) > dimension - 1) ) {
        if(board.hexagons[i+1][j+1].getState() == hex.getState()) {
        sameAdjacent.add(board.hexagons[i+1][j+1]);
        }
        }
        return sameAdjacent;
        }
    public ArrayList<Hexagon> analyzeEmptyAdjacent(Hexagon hex, Board board) {
        int i = hex.getX();
        int j = hex.getY();
        emptyAdjacent = new ArrayList<>();
        //int dimension = board.getDimension();
        int dimension = 8;

        // i constant
        if ( !((j+1) > dimension - 1 ) ) {
            if(board.hexagons[i][j+1].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i][j+1]);
            }
        }
        if ( !((j-1) < 0) ) {
            if(board.hexagons[i][j-1].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i][j-1]);
            }
        }
//j constant
        if ( !((i+1) > dimension - 1 ) ) {
            if(board.hexagons[i+1][j].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i+1][j]);
            }
        }
        if ( !((i-1) < 0) ) {
            if(board.hexagons[i-1][j].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i-1][j]);
            }
        }
        // i-1 j-1
        if ( (!((j-1) < 0)) && !((i-1) < 0 ) ) {
            if(board.hexagons[i-1][j-1].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i-1][j-1]);

            }
        }
        //i+1 j+1
        if ( (!((j+1) > dimension - 1)) && !((i+1) > dimension - 1) ) {
            if(board.hexagons[i+1][j+1].getState() == States.empty) {
                emptyAdjacent.add(board.hexagons[i+1][j+1]);
            }
        }
        return emptyAdjacent;
    }
}
