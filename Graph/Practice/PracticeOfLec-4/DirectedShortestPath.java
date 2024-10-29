import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

public class DirectedShortestPath {
    public static HashMap<Integer, List<Pair>> adj = new HashMap<>();

    public static void topoOrderDFSUtil(int src, HashMap<Integer, Boolean> visited, Stack<Integer> st) {
        visited.put(src, true);

        if (adj.containsKey(src)) {
            for (Pair nbr : adj.get(src)) {
                int nbrNode = nbr.node;
                if (!visited.containsKey(nbrNode)) {
                    topoOrderDFSUtil(nbrNode, visited, st);
                }
            }
        }

        st.push(src);
    }

    public static void topoOrderDFS(int n) {
        int src = 0;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        topoOrderDFSUtil(src, visited, st);

        shortestPath(n, st);
    }

    public static void shortestPath(int n, Stack<Integer> st) {
        int dest[] = new int[n];
        Arrays.fill(dest, Integer.MAX_VALUE);

        int src = st.pop();
        dest[src] = 0;

        if (!adj.containsKey(src)) {
            return;
        }

        for (Pair nbr : adj.get(src)) {
            int nbrNode = nbr.node;
            int nbrDist = nbr.dist;
            if (nbrDist + dest[src] < dest[nbrNode]) {
                dest[nbrNode] = nbrDist + dest[src];
            }   
        }

        while (!st.isEmpty()) {
            int frontNode = st.pop();
            
            if (!adj.containsKey(frontNode)) {
                continue;
            }

            for (Pair nbr : adj.get(frontNode)) {
                int nbrNode = nbr.node;
                int nbrDist = nbr.dist;
                if (nbrDist + dest[frontNode] < dest[nbrNode]) {
                    dest[nbrNode] = dest[frontNode] + nbrDist;
                }
            }
        }

        for (int i : dest) {
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

        // g.printAdj();
        int n = 5;
        topoOrderDFS(n);
    }
}