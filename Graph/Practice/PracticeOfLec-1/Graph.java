import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Graph {
    public HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v, boolean direction) { // tc: (v + e)
        // direction -> false -> undirected
        // direction -> true -> directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) { // Directed graph
            adjList.get(u).add(v);
        } else { // Undirected graph
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println("Printing AdjList");
        printAdjList();
    }

    public void printAdjList() {
        for (int src : adjList.keySet()) {
            System.out.print(src + " -> {");
            for (Integer neighbor : adjList.get(src)) {
                System.out.print(neighbor + ", ");
            }
            System.out.println("}");
        }
    }

    public void bfs(Integer src, HashMap<Integer, Boolean> vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!vis.containsKey(nbr)) {
                    q.add(nbr);
                    vis.put(nbr, true);
                }
            }
        }
    }


    public void dfs(int src, HashMap<Integer, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfs(nbr, visited);
                }
            }
        }
    }
}
