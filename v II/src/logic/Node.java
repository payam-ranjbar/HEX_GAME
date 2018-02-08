package logic;

import entities.Hexagon;

import java.util.ArrayList;

public class Node {
    public Node parent;
    public ArrayList<Node> children;
    public Hexagon key;

    public Node(Hexagon hex) {
        key = hex;
        children = new ArrayList<>();
    }

    public Node(Node parent) {
        parent.addToChildren(this);

    }

    public void addToChildren(Node node) {
        children.add(node);
    }

}
