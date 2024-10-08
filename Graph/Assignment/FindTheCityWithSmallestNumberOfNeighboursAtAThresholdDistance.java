import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance {
    public static int dijkstra(int src, int n, HashMap<Integer, List<int[]>> adjList, int distanceThreshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            
            if (currDist > distanceThreshold || !adjList.containsKey(currNode)) {
                continue;
            }
            
            for (int[] neighbor : adjList.get(currNode)) {
                int nbrNode = neighbor[0];
                int nbrDist = neighbor[1];
                
                if (dist[currNode] + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = dist[currNode] + nbrDist;
                    pq.offer(new int[]{nbrNode, dist[nbrNode]});
                }
            }
        }
        
        int reachableCitiesCount = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) {
                reachableCitiesCount++;
            }
        }
        
        return reachableCitiesCount;
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create an adjacency list using a map of lists
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(new int[] { v, w });
            adjList.get(v).add(new int[] { u, w });
        }

        int city = 0;
        int minReachableCities = Integer.MAX_VALUE;

        for (int u = 0; u < n; u++) {
            int reachableCitiesCount = dijkstra(u, n, adjList, distanceThreshold);

            if (reachableCitiesCount <= minReachableCities) {
                minReachableCities = reachableCitiesCount;
                city = u;
            }
        }

        return city;
    }

    public static void main(String[] args) {
        int n1 = 4,
                edges1[][] = { { 0, 1, 3 },
                        { 1, 2, 1 },
                        { 1, 3, 4 },
                        { 2, 3, 1 } },
                distanceThreshold1 = 4;
        System.out.println(findTheCity(n1, edges1, distanceThreshold1));
        int n2 = 5,
                edges2[][] = { { 0, 1, 2 },
                        { 0, 4, 8 },
                        { 1, 2, 3 },
                        { 1, 4, 2 },
                        { 2, 3, 1 },
                        { 3, 4, 1 } },
                distanceThreshold2 = 2;
        System.out.println(findTheCity(n2, edges2, distanceThreshold2));
    }
}
