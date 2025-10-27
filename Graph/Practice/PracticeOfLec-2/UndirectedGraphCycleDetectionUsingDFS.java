import java.util.HashMap;
import java.util.List;

public class UndirectedGraphCycleDetectionUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean dfs(int src, int parent, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (nbr == parent) {
                continue;
            }

            if (!visited.containsKey(nbr)) {
                if (dfs(nbr, src, visited)) {
                    return true;
                }
            } else if (visited.get(nbr)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCylic(int V) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node < V; node++) {
            if (!visited.containsKey(node)) {
                if (dfs(node, -1, visited)) {
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