import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    public void addEdge(int u, int v, int wt, boolean direction, HashMap<Integer, List<Pair>> adjList) {
        // direction - false - undirected
        // direction - true - directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(new Pair(v, wt));
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, wt));
        }
    }

    public void printAdjList(HashMap<Integer, List<Pair>> adjList) {
        for (int src : adjList.keySet()) {
            System.out.print(src + " {");
            for (Pair neighbour : adjList.get(src)) {
                System.out.print(" { " + neighbour.data + ", " + " " + neighbour.dist + "} ");
            }
            System.out.println(" }");
        }
        System.out.println();
    }
}