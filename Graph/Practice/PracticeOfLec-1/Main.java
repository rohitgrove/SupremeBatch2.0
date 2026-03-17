import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        // undirected
        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 5, false);
        g.addEdge(5, 3, false);
        g.printAdj();
        g.bfs(0, 5);
        g = new Graph();

        // directed
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 5, true);
        g.addEdge(5, 3, true);
        g.printAdj();
        g.dfs(0, 5);
        System.out.println();

        // Weighted Directed
        WeightedGraph<Integer> wg = new WeightedGraph<>();
        wg.addEdge(0, 1, 5, true);
        wg.addEdge(1, 2, 7, true);
        wg.addEdge(1, 3, 6, true);
        wg.addEdge(2, 3, 8, true);
        wg.addEdge(3, 4, 9, true);
        wg.addEdge(4, 5, 11, true);
        wg.addEdge(5, 3, 15, true);
        wg.printAdj();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int src = 0; src < 6; src++) {
            if (!vis.containsKey(src)) {
                wg.bfsUtil(src, vis);
            }
        }
        System.out.println();

        WeightedGraph<Character> wg1 = new WeightedGraph<>();
        wg1.addEdge('a', 'b', 5, false);
        wg1.addEdge('a', 'c', 7, false);
        wg1.addEdge('b', 'd', 6, false);
        wg1.addEdge('c', 'e', 8, false);
        wg1.addEdge('c', 'f', 81, false);
        wg1.printAdj();
        HashMap<Character, Boolean> vis1 = new HashMap<>();
        for (char src = 'a'; src <= 'f'; src++) {
            if (!vis1.containsKey(src)) {
                wg1.dfsUtil(src, vis1);
            }
        }

    }
}
