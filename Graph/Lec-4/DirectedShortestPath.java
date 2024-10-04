import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import java.util.Arrays;

public class DirectedShortestPath {
    public static HashMap<Integer, List<Pair>> adj = new HashMap<>();

    public static void topoOrderDFSUtil(int src, Stack<Integer> topo, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);

        if (adj.containsKey(src)) {
            for (Pair nbrPair : adj.get(src)) {
                int nbrNode = nbrPair.node;
                if (!visited.containsKey(nbrNode)) {
                    topoOrderDFSUtil(nbrNode, topo, visited);
                }
            }
        }

        topo.push(src);
    }

    public static void topoOrderDFS(int n) {
        int src = 0;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        topoOrderDFSUtil(src, st, visited);

        shortestPath(st, n);
    }

    public static void shortestPath(Stack<Integer> topoOrder, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // intially, Maintain src
        int src = topoOrder.pop();
        dist[src] = 0;

        if (!adj.containsKey(src)) {
            return;
        }

        // update nbr distance for this src node
        for (Pair nbrPair : adj.get(src)) {
            int nbrNode = nbrPair.node;
            int nbrDist = nbrPair.dist;
            if (dist[src] + nbrDist < dist[nbrNode]) {
                dist[nbrNode] = dist[src] + nbrDist;
            }
        }

        // apply the same above concept for all the remaining node
        // int the topo ordering
        while (!topoOrder.empty()) {
            src = topoOrder.pop();

            if (!adj.containsKey(src)) {
                continue;
            }

            // update nbr distance for this src node
            for (Pair nbrPair : adj.get(src)) {
                int nbrNode = nbrPair.node;
                int nbrDist = nbrPair.dist;
                if (dist[src] + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = dist[src] + nbrDist;
                }
            }
        }

        // ab mera distance array ekdum tayar hai
        System.out.println("Printing the distance array: ");
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
