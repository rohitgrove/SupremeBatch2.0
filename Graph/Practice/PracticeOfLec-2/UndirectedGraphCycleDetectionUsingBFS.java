import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycleDetectionUsingBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean bfs(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.offer(src);
        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            for (int nbr : adjList.get(frontNode)) {
                if (nbr == parent.get(frontNode)) {
                    continue;
                }

                if (!visited.containsKey(nbr)) {
                    q.offer(nbr);
                    visited.put(nbr, true);
                    parent.put(nbr, frontNode);
                } else if (visited.get(nbr)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCylic(int V) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node < V; node++) {
            if (!visited.containsKey(node)) {
                if (bfs(node, visited)) {
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
