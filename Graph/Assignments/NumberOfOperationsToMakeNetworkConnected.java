public class NumberOfOperationsToMakeNetworkConnected {
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

    public static int makeConnected(int n, int[][] connections) {
        // need to find nocc, no of Extra edges
        int parent[] = new int[n];
        int rank[] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int noExtraEdges = 0;
        for (int connection[] : connections) {
            int u = connection[0];
            int v = connection[1];

            u = findParent(parent, u);
            v = findParent(parent, v);

            if (u != v) {
                unionSet(u, v, parent, rank);
            } else {
                noExtraEdges++;
            }
        }

        int nocc = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                nocc++;
            }
        }

        int ans = nocc - 1; // no of cables needed, no. of ops needed
        return noExtraEdges >= ans ? ans : -1;
    }

    public static void main(String[] args) {
        int n1 = 4, connections1[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(makeConnected(n1, connections1));

        int n2 = 6, connections2[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
        System.out.println(makeConnected(n2, connections2));

        int n3 = 6, connections3[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 } };
        System.out.println(makeConnected(n3, connections3));
    }
}