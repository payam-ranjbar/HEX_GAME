package gui;

import controller.OnePlayerMouseListener;
import controller.RestartButtonListener;
import entities.GamePlay;
import controller.TwoPlayerMouseListener;
import entities.*;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
    final static ImageIcon SELECTED_YELLOW = new ImageIcon("assets/b_glow_yellow.png");
    final static ImageIcon SELECTED_RED = new ImageIcon("assets/b_glow_gray.png");
    final static ImageIcon SELECTED = new ImageIcon("assets/b_glow.png");
    final static ImageIcon YELLOW = new ImageIcon("assets/b1.png");
    final static ImageIcon BLACK = new ImageIcon("assets/b0.png");
    final static ImageIcon RED = new ImageIcon("assets/b2.png");
    final static ImageIcon THINKING = new ImageIcon("assets/thinking.gif");
    final static int HEIGHT = 480;
    final static int WIDTH = 640;
    GuiHexagons[][] hexagons = new GuiHexagons[8][8];
    JLabel restartButton;
    JLabel thinking = new JLabel(THINKING);
    GamePlay game;
    Board board;
    GameModes mode;

    public GameScreen(GamePlay gamePlay, Board board) {
        thinking.setBounds(10, 20, 50, 50);
        thinking.setVisible(true);
        game = gamePlay;
        mode = gamePlay.getGameMode();
        this.board = board;
        setSize(WIDTH,HEIGHT);
        setTitle("HEX The Game");
        JPanel bord = new JPanel();
        bord.setBounds(0, 0, 640, 400);
        bord.setBackground(Color.lightGray);
        drawRestartButton();
        drawBoardBorders();
        setBoard();
        drawBoard();
        add(bord);
        restartButtonInitializer();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);


    }

    public void setBoard() {
        for (int i = 0; i<8; i++) {
            for (int j = 0; j < 8; j++){
                hexagons[i][j] = new GuiHexagons(i, j, BLACK);
            }
        }
    }

    public void drawBoard() {
        int dist = 210;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++){
                hexagons[i][j].setBounds((j*40) + dist + 20 ,(i*(35)) + 20 , 40, 47);
                if (mode == GameModes.PersonVsPerson) {
                    hexagons[i][j].getElement().addMouseListener(new TwoPlayerMouseListener(this, game, i, j));
                } else {
                    hexagons[i][j].getElement().addMouseListener(new OnePlayerMouseListener(this, game, i, j));
                }
                add(hexagons[j][i].getElement());
            }
            dist -= 20;
        }
    }

    public void drawBoardBorders() {
        JLabel leftGrid = new JLabel(new ImageIcon("assets/leftGrid.png"));
        JLabel rightGrid = new JLabel(new ImageIcon("assets/rightGrid.png"));
        JLabel upGrid = new JLabel(new ImageIcon("assets/upGrid.png"));
        JLabel downGrid = new JLabel(new ImageIcon("assets/downGrid.png"));

        leftGrid.setBounds(77, 12, 171, 294);
        add(leftGrid);
        rightGrid.setBounds(390, 28, 175,294);
        add(rightGrid);
        upGrid.setBounds(241, 5, 319, 28);
        add(upGrid);
        downGrid.setBounds(80, 300, 319, 28);
        add(downGrid);

    }

    public void drawRestartButton() {
        restartButton = new JLabel(new ImageIcon("assets/Restart.png"));
        restartButton.setBounds(150, 350, 287, 72);
        add(restartButton);

    }

    public GuiHexagons getHexagons(int i, int j) {
        return hexagons[i][j];
    }

    public void restartButtonInitializer(){
        restartButton.addMouseListener(new RestartButtonListener(restartButton, this));
    }


    public void setHexagonsState(int x, int y, States state) {
        hexagons[x][y].setIcon(state.getImageIcon());
    }
}
