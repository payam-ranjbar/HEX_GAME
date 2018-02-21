package controller;

import gui.GameScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class RestartButtonListener implements MouseListener {
    final static String TurnSaverFile = "Files/turnsaver.dat";
    final static ImageIcon PRESSED = new ImageIcon("assets/RestartClicked.png");
    final static ImageIcon RELEASED = new ImageIcon("assets/Restart.png");
    private JLabel button;
    private GameScreen gameScreen;

    public RestartButtonListener(JLabel button, GameScreen gameScreen) {
        this.button = button;
        this.gameScreen = gameScreen;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            FileOutputStream file = new FileOutputStream(TurnSaverFile);
            file.write("1".getBytes());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        gameScreen.setVisible(false);
        TheGame newGame = new TheGame();



    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.setIcon(PRESSED);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setIcon(RELEASED);

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        button.setIcon(PRESSED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setIcon(RELEASED);
    }
}
