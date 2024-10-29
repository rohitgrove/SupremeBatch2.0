import java.util.HashMap;
import java.util.List;

public class ChechCycleDirectedUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean DFSDirected(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, Boolean> dfsTrack) {
        visited.put(src, true);
        dfsTrack.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    boolean ans = DFSDirected(nbr, visited, dfsTrack);
                    if (ans) {
                        return true;
                    }
                }
                if (visited.get(nbr) && dfsTrack.get(nbr)) {
                    return true;
                }
            }
        }

        dfsTrack.put(src, false);
        return false;
    }

    public static boolean checkCycleDirectedGraghDFS(int n) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Boolean> dfsTrack = new HashMap<>();

        for (int node = 0; node < n; node++) {
            if (!visited.containsKey(node)) {
                boolean ans = DFSDirected(node, visited, dfsTrack);
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
