import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Graph g = new Graph();
        // g.addEdge(0, 1, true);
        // g.addEdge(1, 2, true);
        // g.addEdge(1, 3, true);
        // g.addEdge(2, 3, true);

        // GraphWithWieght<Integer> g = new GraphWithWieght<>();
        // g.addEdge(0, 1, 5, false);
        // g.addEdge(1, 2, 10, false);
        // g.addEdge(1, 3, 20, false);
        // g.addEdge(2, 3, 20, false);


        // GraphWithWieght<Character> g = new GraphWithWieght<>();
        // g.addEdge('a', 'b', 5, false);
        // g.addEdge('a', 'c', 10, false);
        // g.addEdge('b', 'c', 20, false);
        // g.addEdge('c', 'd', 50, false);
        // g.addEdge('c', 'e', 50, false);
        // g.addEdge('e', 'f', 50, false);

        // g.bfsTraversal('a');

        GraphWithWieght<Character> g = new GraphWithWieght<>();
        g.addEdge('a', 'b', 5, false);
        g.addEdge('b', 'c', 20, false);

        g.addEdge('d', 'e', 50, false);

        g.addEdge('f', 'f', 50, false);

        HashMap<Character, Boolean> visited = new HashMap<>();
        for (char node = 'a'; node <= 'f'; node++) {
            if (!visited.containsKey(node)) {
                g.dfsTraversal(node, visited);
            }
        }
    }
}
