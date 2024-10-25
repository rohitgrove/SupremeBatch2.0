import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class KosaRaju {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void dfs1(int node, Stack<Integer> oredring, HashMap<Integer, Boolean> vis) {
        vis.put(node, true);

        if (adjList.containsKey(node)) {
            for (int nbr : adjList.get(node)) {
                if (!vis.containsKey(nbr)) {
                    dfs1(nbr, oredring, vis);
                }
            }
        }
        
        oredring.push(node);
    }

    public static void dfs2(int node, HashMap<Integer, Boolean> vis, HashMap<Integer, List<Integer>> adjNew) {
        vis.put(node, true);
        System.out.print(node + ", ");

        if (adjNew.containsKey(node)) {
            for (int nbr : adjNew.get(node)) {
                if (!vis.containsKey(nbr)) {
                    dfs2(nbr, vis, adjNew);
                }
            }
        }
    }

    public static int getStronglyConnectedComponents(int n) {
        Stack<Integer> ordering = new Stack<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!vis.containsKey(i)) {
                dfs1(i, ordering, vis);
            }
        }

        HashMap<Integer, List<Integer>> adjNew = new HashMap<>();
        for (int a : adjList.keySet()) {
            for (int b : adjList.get(a)) {
                int u = a;
                int v = b;
                adjNew.putIfAbsent(v, new ArrayList<>());
                adjNew.get(v).add(u);
            }
        }

        int count = 0;
        HashMap<Integer, Boolean> vis2 = new HashMap<>();

        while (!ordering.isEmpty()) {
            int node = ordering.pop();
            if (!vis2.containsKey(node)) {
                System.out.print("SCC #" + (count + 1) + ": ");
                dfs2(node, vis2, adjNew);
                System.out.println();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(2, 4, true, adjList);
        g.addEdge(3, 0, true, adjList);
        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 4, true, adjList);
        g.addEdge(6, 7, true, adjList);
        System.out.println(getStronglyConnectedComponents(8));
    }
}