import java.util.HashMap;
import java.util.List;

public class NumberOfConnectedCompnenetsUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void dfsUtil(int src, HashMap<Integer,Boolean> visited) {
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfsUtil(nbr, visited);
                }
            }
        }
    }

    public static int dfs(int v) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i <= v; i++) {
            if (!visited.containsKey(i)) {
                dfsUtil(i, visited);
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
        System.out.println(dfs(8));
    }
}
