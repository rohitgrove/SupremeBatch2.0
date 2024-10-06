import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ShortestPathDirectedGraph {
    public static HashMap<Integer, List<Pair>> adj = new HashMap<>();

    public static void topoOrderDFSUtil(int src, HashMap<Integer, Boolean> visited, Stack<Integer> topoOrder) {
        visited.put(src, true);

        if (adj.containsKey(src)) {
            for (Pair nbr : adj.get(src)) {
                int nbrData = nbr.node;
                if (!visited.containsKey(nbrData)) {
                    topoOrderDFSUtil(nbrData, visited, topoOrder);
                }
            }
        }

        topoOrder.push(src);
    }

    public static void topoOrderDFS(int n) {
        int src = 0;
        Stack<Integer> topoOrder = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        topoOrderDFSUtil(src, visited, topoOrder);

        shortestPathBFS(topoOrder, n);
    }

    public static void shortestPathBFS(Stack<Integer> topoOrder, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int src = topoOrder.pop();
        dist[src] = 0;

        if (!adj.containsKey(src)) {
            return;
        }

        for (Pair nbr : adj.get(src)) {
            int nbrNode = nbr.node;
            int nbrDist = nbr.dist;
            if (dist[src] + nbrDist < dist[nbrNode]) {
                dist[nbrNode] = dist[src] + nbrDist;
            }
        }

        while (!topoOrder.isEmpty()) {
            src = topoOrder.pop();

            if (!adj.containsKey(src)) {
                continue;
            }

            for (Pair nbr : adj.get(src)) {
                int nbrNode = nbr.node;
                int nbrDist = nbr.dist;
                if (dist[src] + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = dist[src] + nbrDist;
                }
            }
        }

        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 5, true, adj);
        g.addEdge(0, 2, 3, true, adj);
        g.addEdge(2, 1, 2, true, adj);
        g.addEdge(1, 3, 3, true, adj);
        g.addEdge(2, 3, 5, true, adj);
        g.addEdge(2, 4, 6, true, adj);
        g.addEdge(4, 3, 1, true, adj);

        // g.printAdj(adj);
        int n = 5;
        topoOrderDFS(n);
    }
}
