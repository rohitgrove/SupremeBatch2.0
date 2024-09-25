import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Gragh {
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
        System.out.println("Printing adjList");
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
