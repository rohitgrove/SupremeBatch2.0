import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijakstraAlgo {
    public static HashMap<Integer, List<Pair>> adj =  new HashMap<>();
    public static void dijkstraShortestPath(int n, int src, int dist) {
        int dest[] = new int[n + 1];
        Arrays.fill(dest, Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        minHeap.add(new Pair(src, 0));

        while (!minHeap.isEmpty()) {
            Pair currPair = minHeap.poll();
            int currNode = currPair.node;
            int currDist = currPair.dist;

            for (Pair nbr : adj.get(currNode)) {
                int nbrNode = nbr.node;
                int nbrDist = nbr.dist;
                if (currDist + nbrDist < dest[nbrNode]) {
                    dest[nbrNode] = currDist + nbrDist;
                    minHeap.add(new Pair(nbrNode, nbrDist + currDist));
                }
            }
        }

        System.out.println("Shortest Distance from " + src + " Node to " + dist + " Node: " + dest[dist]);
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
