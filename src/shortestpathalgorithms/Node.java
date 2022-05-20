package shortestpathalgorithms;

import java.util.Comparator;

public class Node implements Comparator<Node> {

    private int dest;
    private int weight;

    public Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public Node() {
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    @Override
    public int compare(Node u, Node v) {
        if (u.getWeight() < v.getWeight()) {
            return -1;
        }
        if (u.getWeight() > v.getWeight()) {
            return 1;
        }
        return 0;
    }
    
    
    
    
    

}
