import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void shortestPath(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();

        q.offer(src);
        parent.put(src, -1);
        vis.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            for (int nbr : adjList.get(frontNode)) {
                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                    parent.put(nbr, frontNode);
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
        g.addEdge(0, 4, false, adjList);
        g.addEdge(4, 1, false, adjList);
        g.addEdge(1, 5, false, adjList);

        g.addEdge(0, 3, false, adjList);
        g.addEdge(3, 5, false, adjList);

        g.addEdge(0, 6, false, adjList);
        g.addEdge(6, 2, false, adjList);
        g.addEdge(2, 5, false, adjList);
        g.printAdjList(adjList);
        shortestPath(0, 5);
    }
}
