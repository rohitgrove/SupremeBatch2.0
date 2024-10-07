import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    public static int findParent(int parent[], int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent, parent[node]); // path compression
    }

    public static void unionSet(int u, int v, int parent[], int rank[]) {
        u = findParent(parent, u);
        v = findParent(parent, v);

        if (rank[u] < rank[v]) {
            parent[u] = v;
            rank[v]++;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Kruskal's Algo
        int parent[] = new int[V];
        int rank[] = new int[V];

        // mark all nodes as individual comp.
        for (int u = 0; u < V; u++) {
            parent[u] = u;
        }

        // make edges linear DS
        List<List<Integer>> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                edges.add(Arrays.asList(u, v, w));
            }
        }

        Collections.sort(edges, (a, b) -> a.get(2) - b.get(2));

        int ans = 0;
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            u = findParent(parent, u);
            v = findParent(parent, v);

            if (u != v) {
                // union
                unionSet(u, v, parent, rank);
                ans += w;
            }
        }

        return ans;
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
