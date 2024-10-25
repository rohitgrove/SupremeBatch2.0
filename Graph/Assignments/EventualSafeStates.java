import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class EventualSafeStates {
    public static boolean DFSDirected(List<List<Integer>> adjList, int src, HashMap<Integer, Boolean> visited,
            HashMap<Integer, Boolean> dfsTrack, boolean[] safeNodes) {
        visited.put(src, true);
        dfsTrack.put(src, true);
        safeNodes[src] = false;

        for (int nbr : adjList.get(src)) {
            if (!visited.containsKey(nbr)) {
                boolean ans = DFSDirected(adjList,nbr, visited, dfsTrack, safeNodes);
                if (ans) {
                    return true;
                }
            }
            if (visited.get(nbr) && dfsTrack.get(nbr)) {
                // cycle present
                return true;
            }
        }

        // [backtrack] Yahi glati karta hu
        dfsTrack.put(src, false);
        safeNodes[src] = true;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Boolean> dfsTrack = new HashMap<>();
        boolean safeNodes[] = new boolean[V];
        for (int node = 0; node < V; node++) {
            if (!visited.containsKey(node)) {
                DFSDirected(adj, node, visited, dfsTrack, safeNodes);
            }
        }

        for (int i = 0; i < V; i++) {
            if (safeNodes[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj1.add(new ArrayList<>());
        }

        adj1.get(0).add(1);
        adj1.get(0).add(2);

        adj1.get(1).add(2);
        adj1.get(1).add(3);

        adj1.get(2).add(5);

        adj1.get(3).add(0);

        adj1.get(4).add(5);

        System.out.println(eventualSafeNodes(V, adj1));

        V = 3;
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj2.add(new ArrayList<>());
        }

        adj2.get(0).add(1);
        adj2.get(1).add(2);
        adj2.get(2).add(0);
        adj2.get(2).add(3);
        System.out.println(eventualSafeNodes(V, adj2));
    }
}