import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Graph g = new Graph();
        // g.addEdge(0, 0, false);
        // g.addEdge(1, 2, false);
        // g.addEdge(1, 3, false);
        // g.addEdge(2, 3, false);
        // g.printAdjList();
        // g.dfs(0, 3);

        // WeightedGraph<Character> g = new WeightedGraph<>();
        // g.addEdge('a', 'b', 5, false);
        // g.addEdge('b', 'c', 10, false);
        // g.addEdge('a', 'c', 20, false);
        // g.addEdge('c', 'd', 50, false);
        // g.printAdjList();

        // System.out.println();
        // WeightedGraph<Integer> graph = new WeightedGraph<>();
        // graph.addEdge(0, 1, 5, false);
        // graph.addEdge(1, 2, 10, false);
        // graph.addEdge(1, 3, 20, false);
        // graph.addEdge(2, 3, 50, false);
        // graph.printAdjList();

        // WeightedGraph<Character> g = new WeightedGraph<>();
        // g.addEdge('a', 'b', 1, false);
        // g.addEdge('a', 'c', 1, false);
        // g.addEdge('b', 'c', 1, false);
        // g.addEdge('c', 'd', 1, false);
        // g.addEdge('c', 'e', 1, false);
        // g.addEdge('c', 'f', 1, false);
        // g.addEdge('e', 'f', 1, false);
        // g.bfsTraversal('a');

        WeightedGraph<Character> g = new WeightedGraph<>();
        g.addEdge('a', 'b', 1, false);
        g.addEdge('b', 'c', 1, false);

        g.addEdge('d', 'e', 1, false);

        g.addEdge('f', 'f', 1, false);
        HashMap<Character, Boolean> visited = new HashMap<>();

        for (char node = 'a'; node <= 'f'; node++) {
            if (!visited.containsKey(node)) {
                g.dfsTraversal(node, visited);
            }
        }
    }
}