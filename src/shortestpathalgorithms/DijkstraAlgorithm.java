package shortestpathalgorithms;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    private final Graph graph;
    private final int source;
    private int distance[];
    private int parent[];
    private boolean isVisited[];
    private PriorityQueue<Node> PQ;

    public DijkstraAlgorithm(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        distance = new int[graph.getV()];
        parent = new int[graph.getV()];
        isVisited = new boolean[graph.getV()];
        PQ = new PriorityQueue<Node>(graph.getV(), new Node());
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
        PQ = new PriorityQueue<Node>(graph.getV(), new Node());
    }

    public void solve() {
        initialize();
        PQ.add(new Node(this.source, 0));
        while (PQ.size() > 0) {
            Node node = PQ.poll();
            isVisited[node.getDest()] = true;

            for (int i = 0; i < graph.adj.get(node.getDest()).size(); i++) {
                {
                    Node n = graph.adj.get(node.getDest()).get(i);
                    if (!isVisited[n.getDest()]) {
                        int tmp = distance[node.getDest()] + n.getWeight();
                        if (tmp < distance[n.getDest()]) {
                            distance[n.getDest()] = tmp;
                            parent[n.getDest()] = node.getDest();
                            PQ.add(new Node(n.getDest(), tmp));
                        }

                    }

                }

            }

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
