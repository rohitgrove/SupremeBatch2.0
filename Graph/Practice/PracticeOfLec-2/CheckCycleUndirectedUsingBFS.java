import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleUndirectedUsingBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean checkCycleUndirectedGraghBFSUtil(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

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
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkCycleUndirectedGraghBFS(int v) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node <= v; node++) {
            if (!visited.containsKey(node)) {
                boolean ans = checkCycleUndirectedGraghBFSUtil(node, visited);
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
        g.addEdge(3, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        int src = 5;
        boolean isCylic = checkCycleUndirectedGraghBFS(src);
        if (isCylic) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("Cycle Not Present");
        }
    }
}
