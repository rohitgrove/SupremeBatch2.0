import java.util.HashMap;
import java.util.List;

public class DirectedGraphCycleDetectionUsingDFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean isCyclicDFS(int src, HashMap<Integer, Boolean> vis, HashMap<Integer, Boolean> dfsTrack) {
        vis.put(src, true);
        dfsTrack.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    if (isCyclicDFS(nbr, vis, dfsTrack)) {
                        return true;
                    }
                } else if (vis.get(nbr) && dfsTrack.get(nbr)) {
                    return true;
                }
            }
        }

        dfsTrack.put(src, false);
        return false;
    }

    public static boolean checkCycleDirectedGraghDFS(int n) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        HashMap<Integer, Boolean> dfsTrack = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                if (isCyclicDFS(i, vis, dfsTrack)) {
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
        adjList = new HashMap<>();

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
