import java.util.HashMap;
import java.util.List;

public class UndirectedGraphCycleDetectionUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean DFSisCyclic(int src, HashMap<Integer, Boolean> vis, int parent) {
        vis.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (nbr == parent) {
                continue;
            }

            if (!vis.containsKey(nbr)) {
                if (DFSisCyclic(nbr, vis, src)) {
                    return true;
                }
            } else if (vis.containsKey(nbr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCyclic(int V) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int node = 0; node < V; node++) {
            if (!vis.containsKey(node)) {
                int parent = -1;
                if (DFSisCyclic(node, vis, parent)) {
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
        // g.addEdge(3, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        int src = 6;
        boolean isCylic = isCyclic(src);
        if (isCylic) {
            System.out.println("Cycle Present hai");
        } else {
            System.out.println("Cycle Present nhi hai");
        }
    }
}
