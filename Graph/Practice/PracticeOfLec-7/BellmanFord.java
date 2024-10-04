import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class BellmanFord {
    public static HashMap<Character, List<Pair<Character>>> adjList = new HashMap<>();

    public static void bellmanFord(int n, char src) {
        int dest[] = new int[n];
        Arrays.fill(dest, Integer.MAX_VALUE);
        dest[src - 'A'] = 0;

        for (int i = 1; i < n; i++) {
            for (char a : adjList.keySet()) {
                for (Pair<Character> b : adjList.get(a)) {
                    char u = a;
                    char v = b.node;
                    int wt = b.wt;
                    if (dest[u - 'A'] != Integer.MAX_VALUE && dest[u - 'A'] + wt < dest[v - 'A']) {
                        dest[v - 'A'] = dest[u - 'A'] + wt;
                    }
                }
            }
        }

        boolean isCylic = false;
        for (int i = 1; i < n; i++) {
            for (char a : adjList.keySet()) {
                for (Pair<Character> b : adjList.get(a)) {
                    char u = a;
                    char v = b.node;
                    int wt = b.wt;
                    if (dest[u - 'A'] != Integer.MAX_VALUE && dest[u - 'A'] + wt < dest[v - 'A']) {
                        isCylic = true;
                        break;
                    }
                }
            }
        }

        if (isCylic) {
            System.out.println("In This graph has cycle");
        } else {
            System.out.println("In This graph has'nt cycle");
            for (int i : dest) {
                System.out.print(i + " ");
            }
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
