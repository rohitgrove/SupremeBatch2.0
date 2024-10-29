import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {
    public void addEdge(T u, T v, int wt, boolean direction, HashMap<T, List<Pair<T>>> adjList) { // tc: (v + e)
        // direction -> false -> undirected
        // direction -> true -> directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(new Pair<>(v, wt));
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair<>(v, wt));
            adjList.get(v).add(new Pair<>(u, wt));
        }
    }

    public void printAdjListWithPair(HashMap<T, List<Pair<T>>> adjList) {
        for (T src : adjList.keySet()) {
            System.out.print(src + ": { ");
            for (Pair<T> nbr : adjList.get(src)) {
                System.out.print("{" + nbr.node + ", " + nbr.wt + "}, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void addEdge(T u, T v, boolean direction, HashMap<T, List<T>> adjList) { // tc: (v + e)
        // direction -> false -> undirected
        // direction -> true -> directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printAdjList(HashMap<T, List<T>> adjList) {
        for (T src : adjList.keySet()) {
            System.out.print(src + ": { ");
            for (T nbr : adjList.get(src)) {
                System.out.print(nbr + ", ");
            }
            System.out.println("}");
        }
        System.out.println();
    }
}