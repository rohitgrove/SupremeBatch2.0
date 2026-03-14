import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    public void addEdge(int u, int v, boolean direction, HashMap<Integer, List<Integer>> adjList) {
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printAdj(HashMap<Integer, List<Integer>> adjList) {
        System.out.println();
        for (int src : adjList.keySet()) {
            System.out.print(src + "-> {");
            for (int neighbour : adjList.get(src)) {
                System.out.print(neighbour + ", ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void bfsUtil(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            // go to nbr
            for (int nbr : adjList.get(frontNode)) {
                int nbrData = nbr;
                if (!visited.containsKey(nbrData)) {
                    q.offer(nbrData);
                    visited.put(nbrData, true);
                }
            }
        }
    }

    public void bfs(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visited.containsKey(node)) {
                bfsUtil(node, visited, adjList);
            }
        }
    }

    public void dfsUtil(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                int nbrData = nbr;
                if (!visited.containsKey(nbrData)) {
                    dfsUtil(nbrData, visited, adjList);
                }
            }
        }
    }

    public void dfs(int src, int nodes, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visted = new HashMap<>();

        for (int node = src; node <= nodes; node++) {
            if (!visted.containsKey(node)) {
                dfsUtil(node, visted, adjList);
            }
        }
    }
}