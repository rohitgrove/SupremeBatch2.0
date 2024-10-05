import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleCheckUndirected {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean BFSUndirected(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        // Initial state
        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            for (int nbr : adjList.get(frontNode)) {
                if (nbr == parent.get(frontNode)) {
                    continue;
                }
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                    parent.put(nbr, frontNode);
                } else if (visited.get(nbr)) {
                    // Cycle present
                    return true;
                }
            }
        }
        // Cycle not present
        return false;
    }

    public static boolean checkCycleUndirectedGraghBFS(int V) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < V; i++) {
            if (!visited.containsKey(i)) {
                boolean ans = BFSUndirected(i, visited);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DFSUndirected(int src, HashMap<Integer, Boolean> vis, int parent) {
        vis.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (nbr == parent) {
                continue;
            }
            if (!vis.containsKey(nbr)) {
                boolean ans = DFSUndirected(nbr, vis, src);
                if (ans) {
                    return true;
                }
            } else if (vis.get(nbr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkCycleUndirectedGraghDFS(int V) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int i = 0; i < V; i++) {
            if (!vis.containsKey(i)) {
                int parent = -1;
                boolean isCyclic = DFSUndirected(i, vis, parent);
                if (isCyclic) {
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
        g.addEdge(3, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        int src = 5;
        boolean isCylic = checkCycleUndirectedGraghDFS(src);
        if (isCylic) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("Cycle Not Present");
        }
    }
}
