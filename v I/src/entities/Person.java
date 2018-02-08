package entities;

public class Person extends Player {
    public Person(Identity id, int turn){
        setIdentity(id);
        setPlayerTurn(turn);
    }
    public PlayerMove play(int x, int y, States state) {
        return  new PlayerMove(x, y, state);
    }
    @Override
    public PlayerMove play() {
        return null;
    }
}
