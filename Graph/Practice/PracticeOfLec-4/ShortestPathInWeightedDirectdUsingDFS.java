import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ShortestPathInWeightedDirectdUsingDFS {
    public static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void topoOrder(int src, HashMap<Integer, Boolean> vis, Stack<Integer> st) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (Pair nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr.data)) {
                    topoOrder(nbr.data, vis, st);
                }
            }
        }

        st.push(src);
    }

    public static void shortestDistance(int n) {
        Stack<Integer> topoOrder = new Stack<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        topoOrder(0, vis, topoOrder);

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int src = topoOrder.pop();
        dist[src] = 0;

        for (Pair nbrPair : adjList.get(src)) {
            int nbrData = nbrPair.data;
            int nbrDist = nbrPair.dist;

            if (nbrDist + dist[src] < dist[nbrData]) {
                dist[nbrData] = nbrDist + dist[src];
            }
        }

        while (!topoOrder.isEmpty()) {
            src = topoOrder.pop();

            if (!adjList.containsKey(src)) {
                continue;
            }

            for (Pair nbrPair : adjList.get(src)) {
                int nbrData = nbrPair.data;
                int nbrDist = nbrPair.dist;

                if (nbrDist + dist[src] < dist[nbrData]) {
                    dist[nbrData] = nbrDist + dist[src];
                }
            }
        }

        for (int dis : dist) {
            System.out.print(dis + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 5, true, adjList);
        g.addEdge(0, 2, 3, true, adjList);
        g.addEdge(2, 1, 2, true, adjList);
        g.addEdge(2, 3, 5, true, adjList);
        g.addEdge(2, 4, 6, true, adjList);
        g.addEdge(1, 3, 3, true, adjList);
        g.addEdge(4, 3, 1, true, adjList);
        g.printAdjList(adjList);
        shortestDistance(5);
    }
}
