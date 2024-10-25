import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeInAGraph {
    public static void criticalConnectionsHelper(int src, int parent, HashMap<Integer, List<Integer>> adjList, int time,
            List<List<Integer>> ans, int[] tin, int[] low, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        tin[src] = time;
        low[src] = time;
        time++;

        if (adjList.containsKey(src)) {
            // nbrs
            for (int nbr : adjList.get(src)) {
                if (nbr == parent) {
                    // ignore this
                    continue;
                }
                if (!visited.containsKey(nbr)) {
                    // step1:
                    criticalConnectionsHelper(nbr, src, adjList, time, ans, tin, low, visited);
                    // low update
                    low[src] =  Math.min(low[src], low[nbr]);
                    // bridge Testing
                    if (low[nbr] > tin[src]) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(src);
                        temp.add(nbr);
                        ans.add(temp);
                    }
                } else {
                    // ek or raasta milgya
                    // low update
                    low[src] = Math.min(low[src], low[nbr]);
                    // no need of bridge testing
                }
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (List<Integer> list : connections) {
            int u = list.get(0);
            int v = list.get(1);
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // main logic
        int time = 1;
        List<List<Integer>> ans = new ArrayList<>();
        int low[] = new int[n];
        int tin[] = new int[n];

        int src = 0;
        int parent = -1;
        HashMap<Integer, Boolean> visited = new HashMap<>();
        criticalConnectionsHelper(src, parent, adjList, time, ans, tin, low, visited);

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> connections1 = new ArrayList<>();
        int n1 = 4;
        for (int i = 0; i < n1; i++) {
            connections1.add(new ArrayList<>());
        }
        connections1.get(0).add(0);
        connections1.get(0).add(1);

        connections1.get(1).add(1);
        connections1.get(1).add(2);

        connections1.get(2).add(2);
        connections1.get(2).add(0);

        connections1.get(3).add(1);
        connections1.get(3).add(3);
        System.out.println(criticalConnections(n1, connections1));

        List<List<Integer>> connections2 = new ArrayList<>();
        int n2 = 2;

        connections2.add(new ArrayList<>());
        connections2.get(0).add(0);
        connections2.get(0).add(1);

        System.out.println(criticalConnections(n2, connections2));
    }
}