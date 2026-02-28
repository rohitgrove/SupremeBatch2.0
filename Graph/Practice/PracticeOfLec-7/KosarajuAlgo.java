import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void dfs1(int node, Stack<Integer> ordering, HashMap<Integer, Boolean> visited) {
        visited.put(node, true);
        if (adjList.containsKey(node)) {
            for (int nbr : adjList.get(node)) {
                if (!visited.containsKey(nbr)) {
                    dfs1(nbr, ordering, visited);
                }
            }
        }

        // wapas aate hue stack me puch
        ordering.push(node);
    }

    public static void dfs2(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjNew) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (adjNew.containsKey(src)) {
            for (int nbr : adjNew.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfs2(nbr, visited, adjNew);
                }
            }
        }
    }

    public static int getStronglyConnectedComponents(int n) {
        // step1: get The Ordering
        Stack<Integer> ordering = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!visited.containsKey(i)) {
                dfs1(i, ordering, visited);
            }
        }

        // step2: reverse edges
        HashMap<Integer, List<Integer>> adjNew = new HashMap<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                int u = src;
                int v = nbr;
                // v -> u ki entry create krni hai
                adjNew.putIfAbsent(v, new ArrayList<>());
                adjNew.get(v).add(u);
            }
        }

        // step3: traverse using ordering and count components
        int count = 0;
        HashMap<Integer, Boolean> visited2 = new HashMap<>();

        while (!ordering.isEmpty()) {
            int node = ordering.pop();
            if (!visited2.containsKey(node)) {
                System.out.print("SCC #" + (count + 1) + ": ");
                dfs2(node, visited2, adjNew);
                count++;
                System.out.println();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(3, 0, true, adjList);

        g.addEdge(2, 4, true, adjList);

        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 4, true, adjList);

        g.addEdge(6, 7, true, adjList);

        System.out.println("SCC Count: " + getStronglyConnectedComponents(8));
    }
}
