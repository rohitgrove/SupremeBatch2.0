import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gragh {
    public Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v, boolean direction) {
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
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> {");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + ", ");
            }
            System.out.println("}");
        }
    }
}
