import java.util.Stack;
import java.util.HashMap;
import java.util.List;

public class TopologicalSortUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topSortDFS(int end) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < end; i++) {
            if (!vis.containsKey(i)) {
                topSortDFSUtil(i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortDFSUtil(int src, HashMap<Integer, Boolean> vis, Stack<Integer> s) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    topSortDFSUtil(nbr, vis, s);
                }
            }
        }

        s.push(src);
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
        topSortDFS(n);
    }
}
