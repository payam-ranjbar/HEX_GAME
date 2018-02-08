package controller;

import gui.GameScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RestartButtonListener implements MouseListener {
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
