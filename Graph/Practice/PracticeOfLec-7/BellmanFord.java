import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BellmanFord {
    public static HashMap<Character, List<Pair<Character>>> adjList = new HashMap<>();

    public static void bellmanFord(int n, char src) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src - 'A'] = 0;

        for (int i = 1; i < n; i++) {
            for (char node : adjList.keySet()) {
                for (Pair<Character> nbr : adjList.get(node)) {
                    int u = node;
                    int v = nbr.data;
                    int wt = nbr.wt;

                    if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + wt < dist[v - 'A']) {
                        dist[v - 'A'] = dist[u - 'A'] + wt;
                    }
                }
            }
        }

        boolean anyUpadate = false;
        for (char node : adjList.keySet()) {
            for (Pair<Character> nbr : adjList.get(node)) {
                int u = node;
                int v = nbr.data;
                int wt = nbr.wt;

                if (dist[u - 'A'] != Integer.MAX_VALUE && dist[u - 'A'] + wt < dist[v - 'A']) {
                    anyUpadate = true;
                    break;
                }
            }
        }

        if (anyUpadate) {
            System.out.println("Cycle is Present");
        } else {
            System.out.println("Cycle is Not Present");
            System.out.print("Print distance Array: ");
            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
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
        bellmanFord(5, 'A');

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
        bellmanFord(5, 'A');
    }
}
