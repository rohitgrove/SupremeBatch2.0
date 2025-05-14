import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    public HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v, boolean direction) {
        adjList.putIfAbsent(u, new ArrayList<>());

        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printAdjList() {
        for (int src : adjList.keySet()) {
            System.out.print(src + " -> {");
            for (int nbr : adjList.get(src)) {
                System.out.print(nbr + ", ");
            }
            System.out.println("}");
        }
    }

    private void bfsTraversalUtil(int src, HashMap<Integer, Boolean> vis) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                }
            }
        }
    }

    public void bfsTraversal(int start, int end) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int node = start; node <= end; node++) {
            if (!vis.containsKey(node)) {
                bfsTraversalUtil(node, vis);
            }
        }
        System.out.println();
    }

    private void dfsUtil(int src, HashMap<Integer, Boolean> vis) {
        vis.put(src, true);
        System.out.print(src + " ");

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    dfsUtil(nbr, vis);
                }
            }
        }
    }

    public void dfsTraversal(int start, int end) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int node = start; node <= end; node++) {
            if (!vis.containsKey(node)) {
                dfsUtil(node, vis);
            }
        }
        System.out.println();
    }
}
