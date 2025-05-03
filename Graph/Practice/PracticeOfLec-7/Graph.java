import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {
    public void addEdge(T u, T v, int wt, boolean direction, HashMap<T, List<Pair<T>>> adjList) {
        // direction = false -> undirected
        // direction = true -> directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(new Pair<>(v, wt));
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair<>(v, wt));
            adjList.get(v).add(new Pair<>(u, wt));
        }
    }

    public void printAdjList(HashMap<T, List<Pair<T>>> adjList) {
        for (T src : adjList.keySet()) {
            System.out.print(src + ": { ");
            for (Pair<T> nbr : adjList.get(src)) {
                System.out.print("{" + nbr.data + ", " + nbr.wt + "}, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }
}