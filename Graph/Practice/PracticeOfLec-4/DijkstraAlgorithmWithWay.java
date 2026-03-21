import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmWithWay {
    static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void dijkstraShortestDistance(int n, int src, int dest) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.dist - b.dist));
        HashMap<Integer, Integer> parent = new HashMap<>();

        minHeap.offer(new Pair(src, 0));
        parent.put(src, -1);

        while (!minHeap.isEmpty()) {
            Pair topElement = minHeap.poll();
            int topData = topElement.data;
            int topDist = topElement.dist;

            if (!adjList.containsKey(topData)) {
                continue;
            }

            for (Pair nbrPair : adjList.get(topData)) {
                int nbrData = nbrPair.data;
                int nbrDist = nbrPair.dist;
                if (nbrDist + topDist < dist[nbrData]) {
                    dist[nbrData] = nbrDist + topDist;
                    minHeap.offer(new Pair(nbrData, nbrDist + topDist));
                    parent.put(nbrData, topData);
                }
            }
        }

        System.out.println("Shortest Distance from " + src + " Node to " + dest + " Node: " + dist[dest]);
        List<Integer> ans = new ArrayList<>();
        while (dest != -1) {
            ans.add(dest);
            dest = parent.get(dest);
        }

        System.out.println(ans.reversed());
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 6, 14, false, adjList);
        g.addEdge(1, 3, 9, false, adjList);
        g.addEdge(1, 2, 7, false, adjList);

        g.addEdge(2, 3, 10, false, adjList);
        g.addEdge(2, 4, 15, false, adjList);

        g.addEdge(3, 4, 11, false, adjList);

        g.addEdge(5, 4, 6, false, adjList);

        g.addEdge(6, 3, 2, false, adjList);
        g.addEdge(6, 5, 9, false, adjList);

        g.printAdj(adjList);
        dijkstraShortestDistance(6, 5, 2);
        dijkstraShortestDistance(6, 6, 4);
    }
}
