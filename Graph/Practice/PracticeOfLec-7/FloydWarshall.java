import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FloydWarshall {
    public static HashMap<Integer, List<Pair<Integer>>> adjList = new HashMap<>();

    public static void flpydWarshal(int n) {
        int dest[][] = new int[n][n];
        for (int[] row : dest) {
            Arrays.fill(row, (int) 1e9);
        }

        for (int i = 0; i < n; i++) {
            dest[i][i] = 0;
        }

        for (int a : adjList.keySet()) {
            for (Pair<Integer> b : adjList.get(a)) {
                int u = a;
                int v = b.node;
                int wt = b.wt;
                dest[u][v] = wt;
            }
        }

        for (int helper = 0; helper < n; helper++) {
            for (int src = 0; src < n; src++) {
                for (int dist = 0; dist < n; dist++) {
                    dest[src][dist] = Math.min(dest[src][dist], dest[src][helper] + dest[helper][dist]); 
                }
            }
        }

        printArr(dest);
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
