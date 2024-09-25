import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // GragpWithWeight<Integer> g = new GragpWithWeight<>();
        // g.addEdge(0, 1, 5, false);
        // g.addEdge(1, 2, 10, false);
        // g.addEdge(1, 3, 20, false);
        // g.addEdge(2, 3, 50, false);

        GragpWithWeight<Character> g = new GragpWithWeight<>();
        g.addEdge('a', 'b', 5, false);
        g.addEdge('b', 'c', 20, false);
        g.addEdge('d', 'e', 50, false);
        g.addEdge('f', 'f', 20, false);
    

        GragpWithWeight<Character> g1 = new GragpWithWeight<>();
        g1.addEdge('a', 'b', 5, false);
        g1.addEdge('c', 'd', 20, false);
        g1.addEdge('c', 'e', 50, false);
        g1.addEdge('d', 'e', 20, false);
        g1.addEdge('e', 'f', 50, false);

        HashMap<Character, Boolean> visited = new HashMap<>();

        // DFS traversal to check for all components
        for (char node = 'a'; node <= 'f'; node++) {
            if (!visited.getOrDefault(node, false)) {
                g.dfs(node, visited);
            }
        }   
        System.out.println();

        HashMap<Character, Boolean> vis = new HashMap<>();
        // BFS traversal to check for all components
        for (char node = 'a'; node <= 'f'; node++) {
            if (!vis.getOrDefault(node, false)) {
                g1.bfs(node, vis);
            }
        }   

        System.out.println();

        GragpWithWeight<Integer> g3 = new GragpWithWeight<>();
        g3.addEdge(0, 1, 5, false);
        g3.addEdge(1, 2, 10, false);
        g3.addEdge(1, 3, 20, false);
        g3.addEdge(2, 3, 50, false);

        g3.addEdge(4, 5, 50, false);
        g3.addEdge(4, 6, 50, false);

        HashMap<Integer, Boolean> visi = new HashMap<>();
        for (int node = 0; node <= 6; node++) {
            g3.bfs(node, visi);            
        }
    }
}
