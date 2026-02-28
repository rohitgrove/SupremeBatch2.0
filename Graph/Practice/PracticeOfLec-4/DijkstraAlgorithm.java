import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void dijkstraShortestDistance(int n, int src, int dest) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        minHeap.offer(new Pair(src, 0));

        while (!minHeap.isEmpty()) {
            Pair srcPair = minHeap.poll();
            int srcData = srcPair.data;
            int srcDist = srcPair.dist;

            if (!adjList.containsKey(srcData)) {
                continue;
            }

            for (Pair nbr : adjList.get(srcData)) {
                int nbrData = nbr.data;
                int nbrDist = nbr.dist;
                if (nbrDist + srcDist < dist[nbrData]) {
                    dist[nbrData] = nbrDist + srcDist;
                    minHeap.offer(new Pair(nbrData, nbrDist + srcDist));
                }
            }
        }

        System.out.println("Shortest Distance from " + src + " Node to " + dest + " Node: " + dist[dest]);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(5, 6, 9, false, adjList);
        g.addEdge(5, 4, 6, false, adjList);
        g.addEdge(6, 3, 2, false, adjList);
        g.addEdge(6, 1, 14, false, adjList);
        g.addEdge(4, 3, 11, false, adjList);
        g.addEdge(4, 2, 15, false, adjList);
        g.addEdge(1, 2, 7, false, adjList);
        g.addEdge(1, 3, 9, false, adjList);
        g.addEdge(2, 3, 10, false, adjList);
        g.printAdjList(adjList);
        int n = 6;
        int src = 5;
        int dist = 2;
        dijkstraShortestDistance(n, src, dist);
        src = 6;
        dist = 4;
        dijkstraShortestDistance(n, src, dist);
    }
}
