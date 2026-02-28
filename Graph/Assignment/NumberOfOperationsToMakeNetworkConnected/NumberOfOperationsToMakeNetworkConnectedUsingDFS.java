import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnectedUsingDFS {
    public static void dfs(int src, boolean[] visited, HashMap<Integer, List<Integer>> adj) {
        visited[src] = true;
        if (adj.containsKey(src)) {
            for (int nbr : adj.get(src)) {
                if (!visited[nbr]) {
                    dfs(nbr, visited, adj);
                }
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                ans++;
            }
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        int n1 = 4, connections1[][] = { { 0, 1 },
                { 0, 2 },
                { 1, 2 } };
        System.out.println(makeConnected(n1, connections1));
        int n2 = 6, connections2[][] = { { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 1, 2 },
                { 1, 3 } };
        System.out.println(makeConnected(n2, connections2));
        int n3 = 6, connections3[][] = { { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 1, 2 } };
        System.out.println(makeConnected(n3, connections3));
    }
}
