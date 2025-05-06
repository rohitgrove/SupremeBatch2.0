import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    public static boolean DFSDirected(int graph[][], int src, boolean[] visited, boolean[] dfsTrack, int safeNodes[]) {
        visited[src] = true;
        dfsTrack[src] = true;

        for (int nbr : graph[src]) {
            if (!visited[nbr]) {
                boolean ans = DFSDirected(graph, nbr, visited, dfsTrack, safeNodes);
                if (ans) {
                    return true;
                }
            }
            if (visited[nbr] && dfsTrack[nbr]) {
                // cycle present
                return true;
            }
        }

        // [backtrack] Yahi glati karta hu
        dfsTrack[src] = false;
        safeNodes[src] = 1;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        boolean visited[] = new boolean[graph.length];
        boolean dfsTrack[] = new boolean[graph.length];
        int safeNodes[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFSDirected(graph, i, visited, dfsTrack, safeNodes);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (safeNodes[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int graph1[][] = { { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {} };
        System.out.println(eventualSafeNodes(graph1));

        int graph2[][] = { { 1, 2, 3, 4 },
                { 1, 2 },
                { 3, 4 },
                { 0, 4 },
                {} };
        System.out.println(eventualSafeNodes(graph2));

        int graph3[][] = { { 1 },
                { 2 },
                { 0, 3 } };
        System.out.println(eventualSafeNodes(graph3));
    }
}