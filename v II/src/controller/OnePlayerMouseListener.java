package controller;

import ai.AI;
import entities.*;
import gui.GameScreen;
import logic.GameLogic;


import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OnePlayerMouseListener implements MouseListener {
    final static ImageIcon SELECTED_YELLOW = new ImageIcon("assets/b_glow_yellow.png");
    final static ImageIcon SELECTED_RED = new ImageIcon("assets/b_glow_gray.png");
    final static ImageIcon SELECTED = new ImageIcon("assets/b_glow.png");
    final static ImageIcon YELLOW = new ImageIcon("assets/b1.png");
    final static ImageIcon BLACK = new ImageIcon("assets/b0.png");
    final static ImageIcon RED = new ImageIcon("assets/b2.png");
    final static String TurnSaverFile = "Files/turnsaver.dat";

    private Board board;
    private GamePlay gamePlay;
    private Icon currentIcon;
    private Hexagon hex;
    private GuiHexagons guiHex;
    private GameScreen view;
    private int turn;
    private AI henry;
    private int elementXPos;
    private int elementYPos;
    private GameModes mode;


    public OnePlayerMouseListener(GameScreen gHex, GamePlay game, int x, int y) {
        hex = new Hexagon();
        elementXPos = x;
        elementYPos = y;
        view = gHex;
        guiHex = gHex.getHexagons(x, y);
        gamePlay = game;
        currentIcon = BLACK;
        board = game.getBoard();
        GuiHexagons elemet = view.getHexagons(elementXPos, elementYPos);
        mode = game.getGameMode();
        turn = game.getPlayerTurn();

        if(mode == GameModes.AIvsPerson) {
            henry = new AI(1, States.blue, gamePlay, view);
            turn = readDataFromTurnSaverFile();

            if (turn == 49) {
                changeTurnSaverFile("2");
                turn = 50;
                int [] pos = henry.beginGame();
                //  System.out.println("AI begins whith hex at x = " + pos[0] +" y = " + pos[1]);
                System.out.println("AI begins");
                view.getHexagons(pos[0], pos[1]).setIcon(YELLOW);
                view.getHexagons(pos[0], pos[1]).setState(States.blue);
            }


        } else {
            henry = new AI(2, States.red, gamePlay, view);

        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (mode == GameModes.PersonVsAI) {
            if (guiHex.getState()  == States.empty) {
                System.out.println("Player 'YELLOW' Clicked Hexagon at, X = " + guiHex.getX() + " Y = " + guiHex.getY());
                guiHex.setIcon(YELLOW);
                guiHex.setState(States.blue);
                currentIcon = YELLOW;
                board.setState(elementXPos, elementYPos, States.blue);
                System.out.println(board.hexagons[elementXPos][elementYPos]);
                hex = board.hexagons[elementXPos][elementYPos];
                henry.getDecider().setBoard(board);
                henry.getListener().set(hex, board);
                int [] pos = new int[2];
                pos = henry.play();
                view.getHexagons(pos[0], pos[1]).setIcon(RED);
                view.getHexagons(pos[0], pos[1]).setState(States.red);
            }
            getWinner(hex);
        }else if (mode == GameModes.AIvsPerson) {

            System.out.println("Game Mode is AI vs Human");
            System.out.println("turn is = " + turn);
            if (guiHex.getState()  == States.empty) {
                System.out.println("Player 'RED'    Clicked Hexagon at, X = " + guiHex.getX() + " Y = " + guiHex.getY());
                guiHex.setIcon(RED);
                guiHex.setState(States.red);
                currentIcon = RED;
                board.setState(elementXPos, elementYPos, States.red);
                hex = board.hexagons[elementXPos][elementYPos];
                System.out.println(board.hexagons[elementXPos][elementYPos]);
                if (turn == 50) {
                    henry.getDecider().setBoard(board);
                    henry.getListener().set(hex, board);
                    int [] pos ;
                    pos = henry.play();
                    view.getHexagons(pos[0], pos[1]).setIcon(YELLOW);
                    view.getHexagons(pos[0], pos[1]).setState(States.blue);
                }
            }
            getWinner(hex);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (guiHex.getIcon() == RED) {
            guiHex.setIcon(SELECTED_RED);
        } else if (guiHex.getIcon() == YELLOW) {
            guiHex.setIcon(SELECTED_YELLOW);
        } else {
            guiHex.setIcon(SELECTED);
        }



    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (guiHex.getState() == States.empty) {
            guiHex.setIcon(BLACK);
        } else if (guiHex.getState() == States.blue) {
            guiHex.setIcon(YELLOW);
        } else {
            guiHex.setIcon(RED);
        }

    }

    public void getWinner(Hexagon hexagon) {
        GameLogic gameLogic = new GameLogic(hexagon, gamePlay);
        States state = gameLogic.getWinner();
        if (state != States.empty) {
            if (state == States.red) {
                JOptionPane.showMessageDialog(view, state + " player wins");
            } else {
                JOptionPane.showMessageDialog(view, "yellow player wins");
            }
        }
    }
    public void changeTurnSaverFile(String str) {
        FileOutputStream fileOutput;
        try {
            fileOutput = new FileOutputStream(TurnSaverFile);
            fileOutput.write(str.getBytes());

        } catch (IOException e1) {
            JOptionPane.showMessageDialog(view, "check player file is missing!!!");
            System.exit(0);
        }

    }
    public int readDataFromTurnSaverFile() {
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream(TurnSaverFile);
            return fileInput.read();

        } catch (IOException e1) {
            JOptionPane.showMessageDialog(view, "check player file is missing!!!");
            System.exit(0);
        }
        return 0;
    }
}