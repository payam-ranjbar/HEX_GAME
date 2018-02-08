package gui;

import controller.NewGameButtonListener;
import entities.Board;
import entities.GameModes;
import entities.GamePlay;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingScreen extends JFrame {
    final static ImageIcon NEW_GAME = new ImageIcon("assets/newGame.png");
    final static ImageIcon NEW_GAME_CLICKED = new ImageIcon("assets/newGameClicked.png");
    final static ImageIcon LOGO = new ImageIcon("assets/hexLOGOBig.png");
    final static ImageIcon PLAYER1 = new ImageIcon("assets/p1Text.png");
    final static ImageIcon PLAYER2 = new ImageIcon("assets/p2Text.png");
    final static ImageIcon AI = new ImageIcon("assets/AIText.png");
    final static int HEIGHT = 480;
    final static int WIDTH = 640;

    private GameModes gameMode;
    private JRadioButton p1Person;
    private JRadioButton p2Person;
    private JRadioButton p1AI;
    private JRadioButton p2AI;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel newGameButton;
    private JLabel p1Text;
    private JLabel p2Text;
    private JLabel AIText;
    private JLabel logo;

    private Board board;

    public SettingScreen(Board board) {
        this.board = board;
        setSize(WIDTH, HEIGHT);
        setTopPanel();
        setMiddlePanel();
        setBottomPanel();
        setButtons();
        radioController();
        add(topPanel);
        newGameButtonInit();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.lightGray);
        setVisible(true);
    }

    public void setTopPanel() {
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 640, 100);
        logo = new JLabel(LOGO);
        logo.setBounds(0, 0, 180, 100);
        topPanel.add(logo);
        topPanel.setBackground(Color.lightGray);

    }

    public void setMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setBounds(0, 100, 640, 155);
        // middlePanel.setBackground(Color.white);
        middlePanel.setLayout(new BorderLayout());
        //middlePanel.
    }

    public void setBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 340, 640, 140);
        newGameButton = new JLabel(NEW_GAME);
        newGameButton.setBounds(150, 340, 321, 72);
        add(newGameButton);
    }

    public void setButtons() {
        p1Person = new JRadioButton();
        p1Person.setBackground(Color.lightGray);
        p1AI = new JRadioButton();
        p1AI.setBackground(Color.lightGray);
        p1Text = new JLabel(PLAYER1);
        AIText = new JLabel(AI);
        p1Text.setIcon(PLAYER1);

        p1Person.setBounds(50, 185, 38, 38);
        p1Text.setBounds(90, 185, 153, 38);
        p1AI.setBounds(250, 185, 38, 38);
        AIText.setBounds(290, 185, 42, 38);

        p2Person = new JRadioButton();
        p2Person.setBackground(Color.lightGray);
        p2Text = new JLabel(PLAYER2);
        p2AI = new JRadioButton();
        p2AI.setBackground(Color.lightGray);
        JLabel AI2Text = new JLabel(AI);

        p2Person.setBounds(50, 231, 38, 38);
        p2Text.setBounds(90, 231, 153, 38);
        p2AI.setBounds(250, 231, 38, 38);
        AI2Text.setBounds(290, 231, 42, 38);


        JLabel yellowPlayer = new JLabel(new ImageIcon("assets/yellowmisc.png"));
        yellowPlayer.setBounds(0, 181, 41, 47);
        JLabel redPlayer = new JLabel(new ImageIcon("assets/redmisc.png"));
        redPlayer.setBounds(0, 228, 41, 47);

        add(yellowPlayer);
        add(redPlayer);
        add(AIText);
        add(AI2Text);
        add(p1Text);
        add(p1Person);
        add(p1AI);
        add(p2Text);
        add(p2Person);
        add(p2AI);
    }

    public void radioController() {
        p1Person.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (p1Person.isSelected()) {
                    p1AI.setSelected(false);
                } else if (p1AI.isSelected()) {
                    p1Person.setSelected(false);
                } else if (p2Person.isSelected()) {
                    p2AI.setSelected(false);
                } else if (p2AI.isSelected()) {
                    p2Person.setSelected(false);
                }

            }
        });
    }

    public GameModes getGameMode() {
        if (p1Person.isSelected() && p2Person.isSelected() && p1AI.isSelected() && p2AI.isSelected()) {
            System.err.println("Error occurred because of choosing incorrect states");
            JOptionPane.showMessageDialog(this, "Oops!  Choose Wisely!!!");
            System.exit(0);

        } else if (p1Person.isSelected() && p2Person.isSelected() && p1AI.isSelected()) {
            JOptionPane.showMessageDialog(this, "Ouch!  Choose Wisely!!!");
            System.err.println("Error occurred because of choosing incorrect states");
            System.exit(0);

        } else if (p1Person.isSelected() && p2Person.isSelected() && p2AI.isSelected()) {
            System.err.println("Error occurred because of choosing incorrect states");
            JOptionPane.showMessageDialog(this, "Oh No!  Choose Wisely!!!");
            System.exit(0);

        } else if (p1Person.isSelected() && p2Person.isSelected()) {
            return GameModes.PersonVsPerson;

        } else if (p1AI.isSelected() && p2Person.isSelected()) {
            return GameModes.AIvsPerson;
        } else if (p1Person.isSelected() && p2AI.isSelected()) {
            return GameModes.PersonVsAI;
        } else if (p1AI.isSelected() && p2AI.isSelected()) {
            return GameModes.AIvsAI;
        } else {
            System.err.println("Error occurred because of choosing incorrect states");
            JOptionPane.showMessageDialog(this, " Choose Wisely!!! ");
            System.exit(0);
        }
        return null;

    }

    public void newGameButtonInit() {
        newGameButton.addMouseListener(new NewGameButtonListener(newGameButton, this));
    }

    public Board getBoard() {
        return board;
    }
}


