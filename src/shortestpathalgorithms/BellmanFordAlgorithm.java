package shortestpathalgorithms;

import java.util.PriorityQueue;

public class BellmanFordAlgorithm {

    private final Graph graph;
    private final int source;
    private int distance[];
    private int parent[];
    private boolean isVisited[];

    public BellmanFordAlgorithm(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        distance = new int[graph.getV()];
        parent = new int[graph.getV()];
        isVisited = new boolean[graph.getV()];
    }

    public void initialize() {
        int n = this.graph.getV();
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            isVisited[i] = false;
        }
        distance[this.source] = 0;
        parent[this.source] = this.source;
        isVisited[this.source] = true;
    }

    public void solve() {
        this.initialize();

        for (int i = 0; i < this.graph.getV() - 1; i++) {

            //
            for (int u = 0; u < this.graph.getV(); u++) {
                for (int v = 0; v < this.graph.adj.get(u).size(); v++) {
                    if (distance[u] + graph.adj.get(u).get(v).getWeight() < distance[graph.adj.get(u).get(v).getDest()]) {
                        distance[graph.adj.get(u).get(v).getDest()] = distance[u] + graph.adj.get(u).get(v).getWeight();
                        parent[graph.adj.get(u).get(v).getDest()] = u;
                    }
                }
            } // O(E)

        }

    }

    public int getDistance(int node) {
        return distance[node];
    }

    public void getPath(Node node) {

    }

    public void getAllDistance() {
        System.out.println("Minimun Distance for each edge from source = " + this.source);
        for (int i = 0; i < graph.getV(); i++) {
            System.out.println("distance[" + i + "]=" + distance[i]);
        }
    }

}
