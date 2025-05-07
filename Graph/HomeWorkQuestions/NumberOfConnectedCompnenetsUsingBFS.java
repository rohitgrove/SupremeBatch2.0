import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedCompnenetsUsingBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void bfsUtil(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.offer(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public static int bfs(int v) {
        int cnt = 0;
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i <= v; i++) {
            if (!visited.containsKey(i)) {
                bfsUtil(i, visited);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(1, 3, true, adjList);
        g.addEdge(2, 3, true, adjList);

        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 6, true, adjList);

        g.addEdge(7, 8, true, adjList);
        g.addEdge(8, 7, true, adjList);
        System.out.println(bfs(8));
    }
}