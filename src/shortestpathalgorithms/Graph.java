package shortestpathalgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Graph {

    private int V;
    private int E;
    ArrayList<ArrayList<Node>> adj;
    ArrayList<ArrayList<Node>> adjRev;

    public Graph() {

    }

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public int getE() {
        return E;
    }

    public void setE(int E) {
        this.E = E;
    }

    public ArrayList<ArrayList<Node>> getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<ArrayList<Node>> adj) {
        this.adj = adj;
    }

    public ArrayList<ArrayList<Node>> getAdjRev() {
        return adjRev;
    }

    public void setAdjRev(ArrayList<ArrayList<Node>> adjRev) {
        this.adjRev = adjRev;
    }

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.adj = new ArrayList<>();
        this.adjRev = new ArrayList<>();
        for (int i = 0; i < this.V; i++) {
            ArrayList<Node> tmp = new ArrayList<>();
            ArrayList<Node> tmp1 = new ArrayList<>();
            adj.add(tmp);
            adjRev.add(tmp1);
        }

    }

    public Graph(int V, int E, ArrayList<ArrayList<Node>> adj, ArrayList<ArrayList<Node>> adjRev) {
        this.V = V;
        this.E = E;
        this.adj = adj;
        this.adjRev = adjRev;
    }

    public void showGraph() {
        System.out.println("G=(V,E) =>" + "G=(" + V + ", " + E + ") ");
        for (int i = 0; i < adj.size(); i++) {
            for (Node node : adj.get(i)) {
                System.out.println("(" + i + ", " + node.getDest() + ", " + node.getWeight() + ")");
            }
        }
    }

    public void inputGraph() throws IOException {
        this.clear();
        for (int i = 0; i < E; i++) {
            int from, to, weight;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String line = input.readLine();
            String[] num = line.split(" ");
            from = Integer.parseInt(num[0]);
            to = Integer.parseInt(num[1]);
            weight = Integer.parseInt(num[2]);
            adj.get(from).add(new Node(to, weight));
            adjRev.get(to).add(new Node(from, weight));
        }
    }

    public void clear() {
        this.adj = null;
        this.adjRev = null;
        this.adj = new ArrayList<>();
        this.adjRev = new ArrayList<>();
        for (int i = 0; i < this.V; i++) {
            ArrayList<Node> tmp = new ArrayList<>();
            ArrayList<Node> tmp1 = new ArrayList<>();
            adj.add(tmp);
            adjRev.add(tmp1);
        }
    }

}
