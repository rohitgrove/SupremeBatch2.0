import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FloydWarshall {
    public static HashMap<Integer, List<Pair<Integer>>> adjList = new HashMap<>();

    public static void flpydWarshal(int n) {
        // intial State
        int dist[][] = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        // diagnal pr 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        // kuch weight graph k andar bhi given h
        // update dist array accordingly
        for (int a : adjList.keySet()) {
            for (Pair<Integer> b : adjList.get(a)) {
                int u = a;
                int v = b.node;
                int wt = b.wt;
                dist[u][v] = wt;
            }
        }

        // main logic - helper logic
        for (int helper = 0; helper < n; helper++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {
                    dist[src][dest] = Math.min(dist[src][dest], dist[src][helper] + dist[helper][dest]);
                }
            }
        }

        // printing dsitance array
        printArr(dist);
    }

    public static void printArr(int dist[][]) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, 3, true, adjList);
        g.addEdge(1, 0, 2, true, adjList);
        g.addEdge(0, 3, 5, true, adjList);
        g.addEdge(1, 3, 4, true, adjList);
        g.addEdge(3, 2, 2, true, adjList);
        g.addEdge(2, 1, 1, true, adjList);
        g.printAdjListWithPair(adjList);
        flpydWarshal(4);
    }
}