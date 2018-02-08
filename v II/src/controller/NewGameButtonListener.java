package controller;

import entities.GamePlay;
import gui.GameScreen;
import gui.SettingScreen;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class NewGameButtonListener implements MouseListener {
    final static ImageIcon PRESSED = new ImageIcon("assets/newGameClicked.png");
    final static ImageIcon RELEASED = new ImageIcon("assets/newGame.png");
    private SettingScreen settingScreen;
    private JLabel button;

    public NewGameButtonListener(JLabel b ,SettingScreen settingScreen) {
        button = b;
        this.settingScreen = settingScreen;

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        settingScreen.setVisible(false);
        GameScreen gameScreen = new GameScreen(new GamePlay(settingScreen.getGameMode(), settingScreen.getBoard()) , settingScreen.getBoard());
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
