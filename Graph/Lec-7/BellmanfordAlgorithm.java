import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class BellmanfordAlgorithm {
    public static HashMap<Character, List<Pair<Character>>> adjList = new HashMap<>();

    public static void bellmanFord(int n, char src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 'A'] = 0;
        // N-1 Times -> Relaxation

        for (int i = 1; i < n; i++) {
            // traverse an entire edge list
            for (char a : adjList.keySet()) {
                for (Pair<Character> b : adjList.get(a)) {
                    char u = a;
                    char v = b.node;
                    int wt = b.wt;
                    if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + wt < dist[v - 'A']) {
                        dist[v - 'A'] = dist[u - 'A'] + wt;
                    }
                }
            }
        }

        // yaha tak shortest distance ready h
        // check for -ve cycle
        // 1 time relaxation
        boolean anyUpdate = false;
        // traverse an entire edge list
        for (Character a : adjList.keySet()) {
            for (Pair<Character> b : adjList.get(a)) {
                char u = a;
                char v = b.node;
                int wt = b.wt;
                if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + wt < dist[v - 'A']) {
                    anyUpdate = true;
                    break;
                }
            }
        }

        if (anyUpdate) {
            System.out.println("Negative Cycle Present in Graph");
        } else {
            System.out.println("No Negative Cycle Present in Graph");
            System.out.println("Printing Distance Array");
            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph<Character> g = new Graph<>();
        g.addEdge('A', 'B', -1, true, adjList);
        g.addEdge('B', 'C', 2, true, adjList);
        g.addEdge('C', 'D', -3, true, adjList);
        g.addEdge('D', 'E', 5, true, adjList);
        g.addEdge('A', 'E', 4, true, adjList);
        g.addEdge('B', 'E', 3, true, adjList);
        g.addEdge('B', 'D', 2, true, adjList);
        g.addEdge('D', 'B', 1, true, adjList);
        g.printAdjListWithPair(adjList);
        bellmanFord(5, 'A');
    }
}