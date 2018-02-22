package entities;

import java.util.Stack;

public class Hexagon {
    private int xPos;
    private int yPos;
    private Attributes attribute;
    private States state;
    private Positions position;
    private Locations location;
    private boolean checked;

    public Hexagon(int x, int y) {
        checked = false;
        xPos = x;
        yPos = y;
        state = States.empty;
        attribute = Attributes.none;
        position = Positions.notSet;
        location = Locations.notSet;

    }

    public Hexagon() {
        checked = false;
        xPos = 0;
        yPos = 0;
        state = States.empty;
        attribute = Attributes.none;
        position = Positions.notSet;
        location = Locations.notSet;
    }
    public void setX(int i) {
        xPos = i;
    }
    public void setY(int i) {
        yPos = i;
    }
    public int getX() {
        return xPos;
    }
    public int getY() {
        return yPos;
    }

    public States getState() {
        return state;
    }

    public Attributes getAttribute() {
        return attribute;
    }

    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean b) {
        checked = b;
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

    public Locations getLocation() {
        return location;
    }

    public Positions getPosition() {
        return position;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public String toString() {

        return "Hexagon at X: " + String.valueOf(xPos) + " Y: " + String.valueOf(yPos) +" State = " + state + " Attribute: " + attribute;
    }
}
