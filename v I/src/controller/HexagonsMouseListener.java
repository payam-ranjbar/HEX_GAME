package controller;

import entities.*;
import gui.GameScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HexagonsMouseListener implements MouseListener {
    final static ImageIcon SELECTED_YELLOW = new ImageIcon("assets/b_glow_yellow.png");
    final static ImageIcon SELECTED_RED = new ImageIcon("assets/b_glow_gray.png");
    final static ImageIcon SELECTED = new ImageIcon("assets/b_glow.png");
    final static ImageIcon YELLOW = new ImageIcon("assets/b1.png");
    final static ImageIcon BLACK = new ImageIcon("assets/b0.png");
    final static ImageIcon RED = new ImageIcon("assets/b2.png");
    final static String TurnSaverFile = "Files/turnsaver.dat";

    private Board board;
    private Icon currentIcon;
    private Hexagon hex;
    private GuiHexagons guiHex;
    private GameScreen view;
    private int turn;
    private Player player1;
    private Player player2;
    private int elementXPos;
    private int elementYPos;

    public HexagonsMouseListener(GameScreen gHex, GamePlay game, int x, int y) {
        elementXPos = x;
        elementYPos = y;
        view = gHex;
        guiHex = gHex.getHexagons(x, y);
        currentIcon = BLACK;
        board = game.getBoard();
        GuiHexagons elemet;
        GameModes mode = game.getGameMode();

        player1 = game.getPlayerByTurn(1);
        player2 = game.getPlayerByTurn(2);
        turn = game.getPlayerTurn();

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        FileOutputStream fileOutput;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream(TurnSaverFile);
            turn =  fileInput.read()  ;

        } catch (IOException e1) {
            JOptionPane.showMessageDialog(view , "check player file is missing!!!");
            System.exit(0);
        }

        if(turn == 49) {
            if(currentIcon == BLACK) {
                System.out.println("Player 'YELLOW' Clicked Hexagon at, X = "+ guiHex.getX()+ " Y = " +guiHex.getY());

                guiHex.setIcon(YELLOW);
                currentIcon = YELLOW;
                board.setState(elementXPos, elementYPos, States.blue);
                try {
                    fileOutput = new FileOutputStream(TurnSaverFile);
                    fileOutput.write("2".getBytes());

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(view , "check player file is missing!!!");
                    System.exit(0);
                }
            }
        }
        if(turn == 50) {
            if(currentIcon == BLACK) {
                System.out.println("Player 'RED'    Clicked Hexagon at, X = " + guiHex.getX()+" Y = " +guiHex.getY());
                guiHex.setIcon(RED);
                currentIcon = RED;
                board.setState(elementXPos, elementYPos, States.red);

                try {
                    fileOutput = new FileOutputStream(TurnSaverFile);
                    fileOutput.write("1".getBytes());

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(view , "check player file is missing!!!");
                    System.exit(0);
                }
            }

        }

        getWinner();

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
        guiHex.setIcon(currentIcon);

    }

    public void getWinner() {

    }
}
