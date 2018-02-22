package entities;

public enum States {
    blue,
    red,
    empty;

    public States reverse() {
        if (this == red) {
            return blue;
        } else if (this == blue) {
            return red;
        }
        return empty;
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
