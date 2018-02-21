package logic;

import entities.*;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Game Logic actually is a Tree
 */
public class GameLogic {
    private Board board;
    private ArrayList<Hexagon> leaves = new ArrayList<>();
    private Hexagon hexagon;


    public GameLogic(Hexagon hexagon, GamePlay game) {
        System.out.println("GameLogic constructor passed Hexagon: " + hexagon);
        this.board = game.getBoard();
        this.hexagon = hexagon;
        unCheckBoard(this.board);
        detectLeaves(new Node(hexagon), this.board);
    }


    public void detectLeaves(Node node, Board board) {
        // node = new Node(hexagon);
        Stack<Hexagon> stack = new Stack<>();
        stack = fillStack(node.key, board);
        if (stack.isEmpty()) {
            return;
        }
        while (!stack.isEmpty()) {
            Hexagon tempHex = stack.pop();
            if (!tempHex.isChecked()) {
                Node tempNode;
                tempHex.setChecked(true);
                tempNode = new Node(tempHex);
                tempNode.parent = node;
                node.children.add(tempNode);
            }
        }

        if (node.children.isEmpty()) {
            setLeaves(node.key);
        }

        for (Node i : node.children) {
            detectLeaves(i, board);
        }
    }


    public Stack<Hexagon> fillStack(Hexagon hexagon, Board board) {

        int i = hexagon.getX();
        int j = hexagon.getY();

        //int dimension = board.getDimension();
        int dimension = 8;
        Stack<Hexagon> allies = new Stack<>();

        // i constant
        if ( !((j+1) > dimension - 1 ) ) {
            if(board.hexagons[i][j+1].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i][j+1]);
                System.out.println("allie1: " + board.hexagons[i][j+1] + "added to stack");
            }
        }
        if ( !((j-1) < 0) ) {
            if(board.hexagons[i][j-1].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i][j-1]);
                System.out.println("allie2: " + board.hexagons[i][j-1] + "added to stack");

            }
        }
        //j constant
        if ( !((i+1) > dimension - 1 ) ) {
            if(board.hexagons[i+1][j].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i+1][j]);
                System.out.println("allie3: " + board.hexagons[i+1][j] + "added to stack");
            }
        }
        if ( !((i-1) < 0) ) {
            if(board.hexagons[i-1][j].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i-1][j]);
                System.out.println("allie4: " + board.hexagons[i-1][j] + "added to stack");
            }
        }
        // i-1 j-1
        if ( (!((j-1) < 0)) && !((i-1) < 0 ) ) {
            if(board.hexagons[i-1][j-1].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i-1][j-1]);
                System.out.println("allie5: " + board.hexagons[i-1][j-1] + "added to stack");
            }
        }
        //i+1 j+1
        if ( (!((j+1) > dimension - 1)) && !((i+1) > dimension - 1) ) {
            if(board.hexagons[i+1][j+1].getState() == hexagon.getState()) {
                allies.push(board.hexagons[i+1][j+1]);
                System.out.println("allie6: " + board.hexagons[i+1][j+1] + "added to stack");
            }
        }
        return allies;
    }

    public ArrayList<Hexagon> getLeaves() {
        return leaves;
    }
    public States getWinner() {
        logLeaves();
        ArrayList<Hexagon> checklist = new ArrayList<>();
        boolean [] conditions = new boolean[2];
        conditions[0] = false;
        conditions[1] = false;
        States state = States.empty;
        if (!leaves.isEmpty()) {
            if (leaves.get(0).getState() == States.blue) {
                state = States.blue;
            } else if (leaves.get(0).getState() == States.red) {
                state = States.red;
            } else {
                System.err.println("Error in getWinner Function at GameLogic class: part1");
            }
        }
        if (state == States.red) {
            for (Hexagon i : leaves) {
                if (i.getY() == 0 || i.getY() == 7) {
                        checklist.add(i);
                    }
            }
            if (!checklist.isEmpty()) {
                for (int i = 0; i < checklist.size(); i++) {
                    if (checklist.get(i).getY() == 0) {
                        conditions[0] = true;
                        checklist.remove(checklist.get(i));
                        if (checklist.isEmpty()) {
                            break;
                        }
                    }
                }
            } else {
                System.err.println("NO Winner detected!");
            }
            if (!checklist.isEmpty()) {
                if (checklist.get(0).getY() == 7) {
                    conditions[1] = true;
                }
            } else {
                System.err.println("NO Winner detected!");
            }

            if (conditions[0] && conditions[1]) {
                return States.red;
            }
        } else if (state == States.blue) {
            for (Hexagon i : leaves) {
                if (i.getX() == 0 || i.getX() == 7) {
                    checklist.add(i);
                }
            }
            if (!checklist.isEmpty()) {
                for (int i = 0; i < checklist.size(); i++) {
                    if (checklist.get(i).getX() == 0) {
                        conditions[0] = true;
                        checklist.remove(checklist.get(i));
                        if (checklist.isEmpty()) {
                            break;
                        }
                    }
                }
            } else {
                System.err.println("NO Winner detected!");
            }
            if (!checklist.isEmpty()) {
                if (checklist.get(0).getX() == 7) {
                    conditions[1] = true;
                }
            } else {
                System.err.println("NO Winner detected!");
            }

            if (conditions[0] && conditions[1]) {
                return States.blue;
            }
        } else {
            System.err.println("NO Winner detected!");
        }
        return States.empty;
    }


    public void setLeaves(Hexagon hexagon) {
        if (hexagon.getState() == States.red) {
            if (hexagon.getAttribute() == Attributes.redSide || hexagon.getAttribute() == Attributes.corner) {
                leaves.add(hexagon);
            }
        } else if (hexagon.getState() == States.blue) {
            if (hexagon.getAttribute() == Attributes.blueSide || hexagon.getAttribute() == Attributes.corner) {
                leaves.add(hexagon);
            }
        }
    }
    public void unCheckBoard(Board board) {
        int d = board.getDimension();
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                board.hexagons[i][j].setChecked(false);
            }
        }
    }

    public void logLeaves() {
        System.out.println("**************************LEAVES***********************");
        for (Hexagon i : leaves) {
            System.out.println(i);
        }
        System.out.println("*******************************************************");
    }
}

