package entities;

public enum States {
    blue,
    red,
    empty;

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
