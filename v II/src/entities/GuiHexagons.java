package entities;

import javax.swing.*;

public class GuiHexagons {
    private int x;
    private int y;
    private JLabel element;
    private ImageIcon icon;
    private States state;

    public GuiHexagons(ImageIcon i){
        element = new JLabel(i);
    }

    public GuiHexagons(int x, int y, ImageIcon i){
        this.x = x;
        this.y = y;
        element = new JLabel(i);
        icon = i;
        state = States.empty;
    }

    public void setIcon(Icon i) {

        element.setIcon(i);
    }

    public void setBounds(int x, int y, int width, int height) {
        element.setBounds(x, y, width, height);
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public JLabel getElement() {
        return element;
    }
    public Icon getIcon() {
        return element.getIcon();
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
}
