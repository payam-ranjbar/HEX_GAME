package entities;

public class PlayerMove {
    private int yPos;
    private int xPos;
    private States color;

    public PlayerMove(int x, int y, States state) {
        setXPos(x);
        setYPos(y);
        setColor(state);
    }
    public void setColor(States color) {
        this.color = color;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public States getColor() {
        return color;
    }
}
