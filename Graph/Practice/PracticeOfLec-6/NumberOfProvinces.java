import java.util.HashMap;

public class NumberOfProvinces {
    public static void dfs(int src, int n, HashMap<Integer, Boolean> vis, int[][] isConnected) {
        vis.put(src, true);

        int col = n;
        for (int nbr = 0; nbr < col; nbr++) {
            if (nbr != src && isConnected[src][nbr] == 1) {
                dfs(nbr, n, vis, isConnected);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                dfs(i, n, vis, isConnected);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int isConnected1[][] = { { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected1));

        int isConnected2[][] = { { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected2));
    }
}