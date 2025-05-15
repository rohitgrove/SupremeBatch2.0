import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public void printAdjList(HashMap<Integer, List<Integer>> adjList) {
        for (int src : adjList.keySet()) {
            System.out.print(src + " -> {");
            for (int nbr : adjList.get(src)) {
                System.out.print(nbr + ", ");
            }
            System.out.println("}");
        }
    }
}
