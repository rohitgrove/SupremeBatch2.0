import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    public HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v, boolean direction) {
        adjList.putIfAbsent(u, new ArrayList<>());
        // direction -> false -> undirected
        // direction -> true -> directed
        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.get(u).add(v);
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
    }

    public void printAdjList() {
        for (int src : adjList.keySet()) {
            System.out.print(src + " : { ");
            for (int neighbour : adjList.get(src)) {
                System.out.print(neighbour + ", ");
            }
            System.out.println("}");
        }
    }

    public void bfsTraversalUtil(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.offer(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public void bfsTraversal(int src, int nodes) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = src; node <= nodes; node++) {
            if (!visited.containsKey(node)) {
                bfsTraversalUtil(node, visited);
            }
        }
    }

    public void dfsTraversalUtil(int src, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (!adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfsTraversalUtil(nbr, visited);
                }
            }
        }
    }

    public void dfsTraversal(int src, int nodes) {
        HashMap<Integer, Boolean> visted = new HashMap<>();

        for (int node = src; node <= nodes; node++) {
            if (!visted.containsKey(node)) {
                dfsTraversalUtil(node, visted);
            }
        }
    }
}