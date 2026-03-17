import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirectedGraphUsingBFS {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void shortestPathUsingBFS(int src, int dist) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.offer(src);
        vis.put(src, true);
        parent.put(src, -1);

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
        while (dist != -1) {
            ans.add(dist);
            dist = parent.get(dist);
        }

        System.out.println(ans.reversed());
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false, adjList);
        g.addEdge(0, 3, false, adjList);
        g.addEdge(0, 4, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(2, 5, false, adjList);
        g.addEdge(3, 5, false, adjList);
        g.addEdge(4, 6, false, adjList);
        g.addEdge(6, 5, false, adjList);

        g.printAdj(adjList);

        shortestPathUsingBFS(0, 5);
    }
}
