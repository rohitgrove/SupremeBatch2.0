import java.util.HashMap;

public class NumberOfProvinsec {
    public static void dfs(int src, HashMap<Integer, Boolean> visited, int[][] isConnected) {
        visited.put(src, true);

        for (int nbrIndex = 0; nbrIndex < isConnected.length; nbrIndex++) {
            if (isConnected[src][nbrIndex] == 1) {
                if (!visited.containsKey(nbrIndex)) {
                    dfs(nbrIndex, visited, isConnected);
                }
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;

        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.containsKey(i)) {
                dfs(i, visited, isConnected);
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