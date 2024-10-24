import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    public HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v, boolean direction) {
        // direction -> false -> undirected
        // direction -> true -> undirected
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            // u se v ki taraf ek edge hai
            // u -> v
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            // u -> v
            adjList.get(u).add(v);
            // v -> u
            adjList.get(v).add(u);
        }
        System.out.println("Printing adjList");
        printAdj();
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
}