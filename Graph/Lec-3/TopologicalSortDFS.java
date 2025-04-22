import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topologicalSortUtil(int src, HashMap<Integer, Boolean> visited, Stack<Integer> st) {
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    topologicalSortUtil(nbr, visited, st);
                }
            }
        }

        st.push(src);
    }

    public static void topologicalSort(int end) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int src = 0; src < end; src++) {
            if (!visited.containsKey(src)) {
                topologicalSortUtil(src, visited, st);
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
        topologicalSort(8);
    }
}
