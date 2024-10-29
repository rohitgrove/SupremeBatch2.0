import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

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
        printAdj();
    }

    public void printAdj() {
        for (int src : adjList.keySet()) {
            System.out.print(src + " -> {");
            for (int neighbour : adjList.get(src)) {
                System.out.print(neighbour + ", ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void bfsTraversal(int src) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
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

    public void dfsTraversal(int src, HashMap<Integer, Boolean> visited) {
        System.out.print(src + " ");
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfsTraversal(nbr, visited);
                }
            }
        }
    }
}