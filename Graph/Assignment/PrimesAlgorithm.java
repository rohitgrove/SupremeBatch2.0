import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesAlgorithm {
    public static int getMinValueNode(int[] key, boolean mst[]) {
        int temp = Integer.MAX_VALUE;
        int index = -1; // rep. actual having min value
        for (int i = 0; i < key.length; i++) {
            if (key[i] < temp && mst[i] == false) {
                temp = key[i];
                index = i;
            }
        }

        return index;
    }

    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // prim's Algo
        int key[] = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean mst[] = new boolean[V]; // to keep travk which all nodes into mst
        int parent[] = new int[V]; // stores final mst relation.
        Arrays.fill(parent, -1);

        key[0] = 0;

        while (true) {
            // Step 1;
            int u = getMinValueNode(key, mst);
            if (u == -1) {
                break;
            }

            // Step 2;
            mst[u] = true;

            // step 3;
            for (int edge[] : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (mst[v] == false && w < key[v]) {
                    key[v] = w;
                    parent[v] = u;
                }
            }
        }

        // find sum of W's of the edges of MST
        int sum = 0;
        for (int u = 0; u < parent.length; u++) {
            if (parent[u] == -1) {
                continue;
            }
            for (int edge[] : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (v == parent[u]) {
                    sum += w;
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
        System.out.println("Test Case 2 - The sum of weights of the Minimum Spanning Tree is: " + result2);
    }
}