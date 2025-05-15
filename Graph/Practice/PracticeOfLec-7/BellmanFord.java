import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {
    public static HashMap<Character, List<Pair<Character>>> adjList = new HashMap<>();

    // This bellmanford code with cycleDetection
    public static void bellmanFord1(int n, char src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 'A'] = 0;
        // N-1 Times -> Relaxation

        for (int i = 1; i < n; i++) {
            // traverse an entire edge list
            for (char a : adjList.keySet()) {
                for (Pair<Character> b : adjList.get(a)) {
                    char u = a;
                    char v = b.data;
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
                char v = b.data;
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
            System.out.print("Printing Distance Array :");
            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // This bellmanford code without cycleDetection
    public static void bellmanFord2(int n, char src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 'A'] = 0;
        // N-1 Times -> Relaxation

        for (int i = 1; i < n; i++) {
            // traverse an entire edge list
            for (char a : adjList.keySet()) {
                for (Pair<Character> b : adjList.get(a)) {
                    char u = a;
                    char v = b.data;
                    int wt = b.wt;
                    if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + wt < dist[v - 'A']) {
                        dist[v - 'A'] = dist[u - 'A'] + wt;
                    }
                }
            }
        }

        // yaha tak shortest distance ready h
        System.out.print("Printing Distance Array :");
        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();

        graph.addEdge('A', 'B', -1, true, adjList);
        graph.addEdge('A', 'E', 4, true, adjList);
        graph.addEdge('B', 'E', 3, true, adjList);
        graph.addEdge('B', 'D', 2, true, adjList);
        graph.addEdge('B', 'C', 2, true, adjList);
        graph.addEdge('C', 'D', -3, true, adjList);
        graph.addEdge('D', 'B', 1, true, adjList);
        graph.addEdge('D', 'E', 5, true, adjList);
        graph.printAdjList(adjList);
        bellmanFord2(5, 'A');

        adjList = new HashMap<>();
        graph.addEdge('A', 'B', -1, true, adjList);
        graph.addEdge('B', 'E', 2, true, adjList);
        graph.addEdge('E', 'D', -3, true, adjList);
        graph.addEdge('D', 'C', 5, true, adjList);
        graph.addEdge('A', 'C', 4, true, adjList);
        graph.addEdge('B', 'C', 3, true, adjList);
        graph.addEdge('B', 'D', 2, true, adjList);
        graph.addEdge('D', 'B', 1, true, adjList);
        graph.printAdjList(adjList);
        bellmanFord2(5, 'A');
    }
}
