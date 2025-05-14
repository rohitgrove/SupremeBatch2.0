import java.util.HashMap;
import java.util.List;

public class DirectedGraphCycleDetectionUsingDFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean dfsUndirected(int src, HashMap<Integer, Boolean> vis, HashMap<Integer, Boolean> dfs) {
        vis.put(src, true);
        dfs.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    boolean ans = dfsUndirected(nbr, vis, dfs);
                    if (ans) {
                        return true;
                    }
                } else if (vis.get(src) && dfs.get(nbr)) {
                    return true;
                }
            }
        }

        dfs.put(src, false);
        return false;
    }

    public static boolean checkCycleDirectedGraghDFS(int V) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        HashMap<Integer, Boolean> dfs = new HashMap<>();

        for (int node = 0; node < V; node++) {
            if (!vis.containsKey(node)) {
                boolean ans = dfsUndirected(node, vis, dfs);
                if (ans) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(2, 4, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 7, true, adjList);

        int n = 8;
        System.out.println(checkCycleDirectedGraghDFS(n));

        Graph g1 = new Graph();
        g1.addEdge(0, 1, true, adjList);
        g1.addEdge(1, 2, true, adjList);
        g1.addEdge(2, 3, true, adjList);
        g1.addEdge(3, 4, true, adjList);
        g1.addEdge(4, 5, true, adjList);
        g1.addEdge(5, 2, true, adjList);

        n = 6;
        System.out.println(checkCycleDirectedGraghDFS(n));
    }
}
