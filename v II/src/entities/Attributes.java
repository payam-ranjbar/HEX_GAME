package entities;

public enum Attributes {
    redSide,
    blueSide,
    corner,
    none;

    @Override
    public String toString() {
        switch (this) {
            case corner: return "corner";
            case redSide: return "redSide";
            case blueSide: return  "blueSide";
        }
        return "none";
    }
}
