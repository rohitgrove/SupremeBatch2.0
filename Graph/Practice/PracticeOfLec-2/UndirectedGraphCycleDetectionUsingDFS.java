import java.util.HashMap;
import java.util.List;

public class UndirectedGraphCycleDetectionUsingDFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean dfsUndirected(int src, HashMap<Integer, Boolean> vis, int parent) {
        vis.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (parent == nbr) {
                continue;
            }

            if (!vis.containsKey(nbr)) {
                boolean ans = dfsUndirected(nbr, vis, src);
                if (ans) {
                    return true;
                }
            } else if (vis.get(nbr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCylic(int src) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int node = 0; node < src; node++) {
            if (!vis.containsKey(node)) {
                int parent = -1;
                boolean ans = dfsUndirected(node, vis, parent);
                if (ans) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(1, 3, false, adjList);

        g.addEdge(2, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        g.addEdge(3, 4, false, adjList);

        int src = 6;
        boolean isCylic = isCylic(src);
        if (isCylic) {
            System.out.println("Cycle Present hai");
        } else {
            System.out.println("Cycle Present nhi hai");
        }
    }
}
