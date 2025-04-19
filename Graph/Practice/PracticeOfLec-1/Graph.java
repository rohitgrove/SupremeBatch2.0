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

    public void printAdj() {
        for (int src : adjList.keySet()) {
            System.out.print(src + "-> {");
            for (int neighbour : adjList.get(src)) {
                System.out.print(neighbour + ", ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void bfsUtil(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            Integer frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                int nbrData = nbr;
                if (!visited.containsKey(nbrData)) {
                    q.offer(nbrData);
                    visited.put(nbrData, true);
                }
            }
        }
    }

    public void bfs(int start, int end) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visited.containsKey(node)) {
                bfsUtil(node, visited);
            }
        }
    }

    public void dfsUtil(int src, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                int nbrData = nbr;
                if (!visited.containsKey(nbrData)) {
                    dfsUtil(nbrData, visited);
                }
            }
        }
    }

    public void dfs(int src, int nodes) {
        HashMap<Integer, Boolean> visted = new HashMap<>();

        for (int node = src; node <= nodes; node++) {
            if (!visted.containsKey(node)) {
                dfsUtil(node, visted);
            }
        }
    }
}