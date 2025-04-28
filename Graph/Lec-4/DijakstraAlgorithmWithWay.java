import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DijakstraAlgorithmWithWay {
    public static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void dijkstraShortestDistance(int n, int src, int dest) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        HashMap<Integer, Integer> parent = new HashMap<>();
        pq.offer(new Pair(src, 0));
        parent.put(src, -1);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Pair srcPair = pq.poll();
            int srcData = srcPair.data;
            int srcDist = srcPair.dist;

            if (!adjList.containsKey(srcData)) {
                continue;
            }

            for (Pair nbPair : adjList.get(srcData)) {
                int nbrData = nbPair.data;
                int nbrDist = nbPair.dist;
                if (nbrDist + srcDist < dist[nbrData]) {
                    dist[nbrData] = nbrDist + srcDist;
                    pq.offer(new Pair(nbrData, nbrDist + srcDist));
                    parent.put(nbrData, srcData);
                }
            }
        }

        System.out.println("Shortest Distance from " + src + " Node to " + dest + " Node: " + dist[dest]);
        List<Integer> ans = new ArrayList<>();
        while (dest != -1) {
            ans.add(dest);
            dest = parent.get(dest);
        }

        Collections.reverse(ans);
        System.out.println(ans);
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
