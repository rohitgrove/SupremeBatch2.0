import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesAlgorithm {
    public static int getMinNode(int[] key, boolean[] mst) {
        int temp = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < key.length; i++) {
            if (key[i] < temp && mst[i] == false) {
                temp = key[i];
                index = i;
            }
        }

        return index;
    }

    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int key[] = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean mst[] = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        key[0] = -1;

        while (true) {
            int u = getMinNode(key, mst);

            if (u == -1) {
                break;
            }

            mst[u] = true;

            for (int edges[] : adj.get(u)) {
                int v = edges[0];
                int wt = edges[1];
                if (mst[v] == false && wt < key[v]) {
                    key[v] = wt;
                    parent[v] = u;
                }
            }
        }

        int sum = 0;
        for (int u = 0; u < parent.length; u++) {
            if (parent[u] == -1) {
                continue;
            }

            for (int edges[] : adj.get(u)) {
                int v = edges[0];
                int wt = edges[1];
                if (v == parent[u]) {
                    sum += wt;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 3;
        int E = 3;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges: {source, destination, weight}
        adj.get(0).add(new int[] { 1, 5 }); // Edge from node 0 to 1 with weight 5
        adj.get(1).add(new int[] { 0, 5 }); // Edge from node 1 to 0 with weight 5 (since it's an undirected graph)

        adj.get(1).add(new int[] { 2, 3 }); // Edge from node 1 to 2 with weight 3
        adj.get(2).add(new int[] { 1, 3 }); // Edge from node 2 to 1 with weight 3

        adj.get(0).add(new int[] { 2, 1 }); // Edge from node 0 to 2 with weight 1
        adj.get(2).add(new int[] { 0, 1 }); // Edge from node 2 to 0 with weight 1

        int result = spanningTree(V, E, adj);

        System.out.println("The sum of weights of the Minimum Spanning Tree is: " + result);

        int V2 = 2;
        int E2 = 1;

        List<List<int[]>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }

        // Adding edges: {source, destination, weight}
        adj2.get(0).add(new int[] { 1, 5 }); // Edge from node 0 to 1 with weight 5
        adj2.get(1).add(new int[] { 0, 5 }); // Edge from node 1 to 0 with weight 5 (undirected graph)

        int result2 = spanningTree(V2, E2, adj2);
        System.out.println("The sum of weights of the Minimum Spanning Tree is: " + result2);

        List<List<int[]>> adj3 = new ArrayList<>();
        int V3 = 5;
        for (int i = 0; i < V3; i++) {
            adj3.add(new ArrayList<>());
        }

        adj3.get(0).add(new int[] { 1, 2 });
        adj3.get(1).add(new int[] { 0, 2 });

        adj3.get(0).add(new int[] { 3, 6 });
        adj3.get(3).add(new int[] { 0, 6 });

        adj3.get(3).add(new int[] { 1, 8 });
        adj3.get(1).add(new int[] { 3, 8 });

        adj3.get(1).add(new int[] { 4, 5 });
        adj3.get(4).add(new int[] { 1, 5 });

        adj3.get(1).add(new int[] { 2, 3 });
        adj3.get(2).add(new int[] { 1, 3 });

        adj3.get(2).add(new int[] { 4, 7 });
        adj3.get(4).add(new int[] { 2, 7 });

        int result3 = spanningTree(V3, V3, adj3);
        System.out.println("The sum of weights of the Minimum Spanning Tree is: " + result3);
    }
}