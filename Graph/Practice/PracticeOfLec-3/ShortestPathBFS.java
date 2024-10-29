import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void shortestPathBFS(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    parent.put(nbr, frontNode);
                    visited.put(nbr, true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (dest != -1) {
            ans.add(dest);
            dest = parent.get(dest);
        }

        Collections.reverse(ans);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 5, false, adjList);
        g.addEdge(5, 4, false, adjList);
        g.addEdge(4, 3, false, adjList);
        g.addEdge(0, 6, false, adjList);
        g.addEdge(6, 3, false, adjList);
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(2, 3, false, adjList);

        int src = 0;
        int dest = 3;
        shortestPathBFS(src, dest);
    }
}