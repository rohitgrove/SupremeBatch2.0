import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    public void addEdge(int u, int v, boolean directed, HashMap<Integer, List<Integer>> adjList) {
        adjList.putIfAbsent(u, new ArrayList<>());
        if (directed) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printAdj(HashMap<Integer, List<Integer>> adjList) {
        for (int src : adjList.keySet()) {
            System.out.print(src + ": { ");
            for (int nbr : adjList.get(src)) {
                System.out.print(nbr + ", ");
            }
            System.out.println("}");
        }
    }

    public void dfsUtil(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        System.out.print(src);
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfsUtil(nbr, visited, adjList);
                }
            }
        }
    }

    public void dfs(int n, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node < n; node++) {
            if (!visited.containsKey(node)) {
                dfsUtil(node, visited, adjList);
            }
        }
    }

    public void bfsUtil(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int srcNode = q.poll();
            System.out.print(srcNode + " ");

            if (!adjList.containsKey(srcNode)) {
                continue;
            }

            for (int nbr : adjList.get(srcNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public void bfs(int n, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = 0; node < n; node++) {
            if (!visited.containsKey(node)) {
                bfsUtil(node, visited, adjList);
            }
        }
    }
}