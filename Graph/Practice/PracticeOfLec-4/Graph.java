import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    public void addEdge(int u, int v, int wt, boolean direction, HashMap<Integer, List<Pair>> adjList) {
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
            System.out.print(src + " -> {");
            for (Pair nbr : adjList.get(src)) {
                System.out.print("{" + nbr.data + ", " + nbr.dist +"}");
            }
            System.out.println("}");
        }
    }
}
