import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topologicalSortUtil(int src, HashMap<Integer, Boolean> vis, Stack<Integer> st) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    topologicalSortUtil(nbr, vis, st);
                }
            }
        }

        st.push(src);
    }

    public static void topologicalSort(int n) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int src = 0; src <= n; src++) {
            if (!vis.containsKey(src)) {
                topologicalSortUtil(src, vis, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(3, 4, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(4, 6, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 7, true, adjList);
        g.printAdjList(adjList);
        topologicalSort(7);
    }
}
