import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GragpWithWeight<T> {
    Map<T, List<Pair<T>>> adjList = new HashMap<>();

    static class Pair<T> {
        T first;
        int second;

        Pair(T first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void addEdge(T u, T v, int wt, boolean direction) {
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
        printAdjList();
    }

    public void printAdjList() {
        for (Map.Entry<T, List<Pair<T>>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": { ");
            for (Pair<T> p : entry.getValue()) {
                System.out.print("{" + p.first + ", " + p.second + "}, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }
}