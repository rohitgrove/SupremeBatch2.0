import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class DijakstraAlgorithm {
    public static HashMap<Integer, List<Pair>> adj = new HashMap<>();

    public static void dijkstraShortestPath(int n, int src, int dest) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        minHeap.add(new Pair(src, 0));

        while (!minHeap.isEmpty()) {
            Pair topPair = minHeap.poll();
            int srcNode = topPair.node;
            int srcDist = topPair.dist;

            if (!adj.containsKey(srcNode)) {
                continue;
            }

            for (Pair nbrPair : adj.get(srcNode)) {
                int nbrNode = nbrPair.node;
                int nbrDist = nbrPair.dist;
                if (srcDist + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = nbrDist + srcDist;
                    minHeap.add(new Pair(nbrNode, nbrDist + srcDist));
                }
            }
        }

        System.out.println("Shortest Distance from " + src + " Node to " + dest + " Node: " + dist[dest]);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 6, 14, false, adj);
        g.addEdge(1, 3, 9, false, adj);
        g.addEdge(1, 2, 7, false, adj);
        g.addEdge(2, 3, 10, false, adj);
        g.addEdge(2, 4, 15, false, adj);
        g.addEdge(3, 4, 11, false, adj);
        g.addEdge(6, 3, 2, false, adj);
        g.addEdge(6, 5, 9, false, adj);
        g.addEdge(5, 4, 6, false, adj);

        int n = 6;
        int src = 5;
        int dist = 2;
        dijkstraShortestPath(n, src, dist);
        src = 6;
        dist = 4;
        dijkstraShortestPath(n, src, dist);
    }
}