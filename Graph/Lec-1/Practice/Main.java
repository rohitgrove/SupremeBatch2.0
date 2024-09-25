import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        // Gragh g = new Gragh();
        // g.addEdge(0, 1, false);
        // g.addEdge(1, 2, false);
        // g.addEdge(1, 3, false);
        // g.addEdge(2, 3, false);

        GragpWithWeight<Integer> g = new GragpWithWeight<>();
        g.addEdge(0, 1, 5, false);
        g.addEdge(1, 2, 10, false);
        g.addEdge(3, 4, 20, false);
        g.addEdge(5, 6, 50, false);

        // g.addEdge(4, 5, 50, false);
        // g.addEdge(4, 6, 50, false);

        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int node = 0; node <= 6; node++) {
            g.bfs(node, vis);            
        }

        System.out.println();

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node <= 6; node++) {
            g.bfs(node, visited);            
        }
    }
}
