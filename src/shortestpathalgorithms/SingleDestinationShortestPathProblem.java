package shortestpathalgorithms;

public class SingleDestinationShortestPathProblem {

    private Graph graph;
    private int destination;

    public SingleDestinationShortestPathProblem(Graph graph, int destination) {
        this.graph = graph;
        this.destination = destination;
    }

    public int[] solveApplyingMultiDijkstra() {
        int distance[] = new int[graph.getV()];
        for (int node = 0; node < graph.getV(); node++) {
            if (node != destination) {
                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph, node);
                dijkstra.solve();
                distance[node] = dijkstra.getDistance(destination);
            }
        }
        return distance;
    }

    public int[] solveReversingGraphApplyingDijkstra() {
        int distance[] = new int[graph.getV()];
        Graph tmpGraph = new Graph(graph.getV(), graph.getE(), graph.adjRev, graph.adj);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(tmpGraph, destination);
        dijkstra.solve();
        for (int node = 0; node < tmpGraph.getV(); node++) {
            distance[node] = dijkstra.getDistance(node);
        }
        return distance;
    }

}
