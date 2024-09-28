import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphWithWeight<T> {
    Map<T, List<Pair<T>>> adjList = new HashMap<>();

    static class Pair<T> {
        T first;
        int second;

        Pair(T first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void addEdge(T u, T v, int wt, boolean direction) { // tc: (v + e)
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

    public void bfs(T src, HashMap<T, Boolean> vis) {
        Queue<T> q = new LinkedList<>();
        q.add(src);
        vis.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode + " ");

            for (Pair<T> nbr : adjList.get(frontNode)) {
                T nbrData = nbr.first;
                if (!vis.containsKey(nbrData)) {
                    q.add(nbrData);
                    vis.put(nbrData, true);
                }
            }
        }
    }

    public void dfs(T src, HashMap<T, Boolean> vis) {
        vis.put(src, true);
        System.out.print(src + " ");

        for (Pair<T> nbr : adjList.get(src)) {
            T nbrData = nbr.first;
            if (!vis.containsKey(nbrData)) {
                dfs(nbrData, vis);
            }
        }
    }
}