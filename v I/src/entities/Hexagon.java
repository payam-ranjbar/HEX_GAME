package entities;

import java.util.Stack;

public class Hexagon {
    private int xPos;
    private int yPos;
    private Attributes attribute;
    private States state;
    public Stack<Hexagon> allies = new Stack<>();

    public Hexagon(int x, int y) {
        xPos = x;
        yPos = y;
        state = States.empty;
        attribute = Attributes.none;
    }

    public Hexagon() {
        xPos = 0;
        yPos = 0;
        state = States.empty;
        attribute = Attributes.none;
    }


    public void setState(States state) {
        this.state = state;
    }

    public void setAttribute(Attributes att) {
        if (attribute == Attributes.redSide && att == Attributes.blueSide) {
            attribute = Attributes.corner;
        } else if (attribute == Attributes.blueSide && att == Attributes.redSide) {
            attribute = Attributes.corner;
        } else {
            attribute = att;
        }
    }

}
