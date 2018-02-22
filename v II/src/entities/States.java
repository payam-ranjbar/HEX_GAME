package entities;

import javax.swing.*;

public enum States {
    blue,
    red,
    empty;

    private final static ImageIcon YELLOW = new ImageIcon("assets/b1.png");
    private final static ImageIcon BLACK = new ImageIcon("assets/b0.png");
    private final static ImageIcon RED = new ImageIcon("assets/b2.png");

    public States reverse() {
        if (this == red) {
            return blue;
        } else if (this == blue) {
            return red;
        }
        return empty;
    }
    public ImageIcon getImageIcon() {
        if (this == red) {
            return RED;
        } else if (this == blue) {
            return YELLOW;
        }
        return BLACK;

    }
    @Override
    public String toString() {
        if (this == blue) {
            return "blue";
        } else if (this == red) {
            return "red";
        }
        return "empty";
    }
}
