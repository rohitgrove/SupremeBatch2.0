import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public void addEdge(int u, int v, boolean direction, HashMap<Integer, List<Integer>> adj) {
        // direction - false - undirected
        // direction - true - directed

        adj.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adj.get(u).add(v);
        } else {
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public void printAdj(HashMap<Integer, List<Integer>> adj) {
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            System.out.print(entry.getKey() + " : {");
            for (Integer nbr : entry.getValue()) {
                System.out.print("{" + nbr + " ,");
            }
            System.out.println("} ");
        }
    }


    public void bfs(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public void printBFS(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visi = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visi.containsKey(node)) {
                bfs(node, visi, adjList);
            }
        }
    }

    public void dfs(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> adjList) {
        System.out.print(src + " ");
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfs(nbr, visited, adjList);
                }
            }
        }
    }

    public void printDFS(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visited.containsKey(node)) {
                dfs(node, visited, adjList);
            }
        }
    }
}