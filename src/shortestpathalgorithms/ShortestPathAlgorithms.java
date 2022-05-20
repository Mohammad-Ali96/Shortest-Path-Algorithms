package shortestpathalgorithms;

import java.io.IOException;
import java.util.PriorityQueue;

public class ShortestPathAlgorithms {
    
    public static void main(String[] args) throws IOException {
        
//        PriorityQueue<Node> PQ = new PriorityQueue<>(4,new Node());
//        PQ.add(new Node(1, 12));
//        PQ.add(new Node(0, 10));
//        PQ.add(new Node(3, 1));
//        PQ.add(new Node(2, 13));
//        while(PQ.size()>0){
//            Node n = PQ.poll();
//            System.out.println(n.getValue());
//        }
//        
        
        Graph graph = new Graph(5, 7);
        graph.inputGraph();
        graph.showGraph();
        
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph, 0);
        dijkstra.solve();
        dijkstra.getAllDistance();
        
        
        SingleDestinationShortestPathProblem sdspp =  new SingleDestinationShortestPathProblem(graph, 4);
        int [] dis1 = sdspp.solveReversingGraphApplyingDijkstra();
        for(int i=0;i<graph.getV();i++){
            System.out.println("distance[" + i + "]=" + dis1[i]);
        }
        
        int [] dis2 = sdspp.solveApplyingMultiDijkstra();
        for(int i=0;i<graph.getV();i++){
            System.out.println("distance[" + i + "]=" + dis2[i]);
        }
        
        System.out.println("Belman Ford Algorthim:");
        BellmanFordAlgorithm bellmanFord = new BellmanFordAlgorithm(graph, 0);
        bellmanFord.solve();
        bellmanFord.getAllDistance();
        
        
        
        
        
    }
    
}
