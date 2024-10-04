import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphWithWeight<T> {
    Map<T, List<Pair<T>>> adjList = new HashMap<>();

    static class Pair<T> {
        T node;
        int wt;

        Pair(T node, int wt) {
            this.node = node;
            this.wt = wt;
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
        for (T src : adjList.keySet()) {
            System.out.print(src + ": { ");
            for (Pair<T> nbr : adjList.get(src)) {
                System.out.print("{" + nbr.node + ", " + nbr.wt + "}, ");
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

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (Pair<T> nbr : adjList.get(frontNode)) {
                T nbrData = nbr.node;
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

        if (adjList.containsKey(src)) {
            for (Pair<T> nbr : adjList.get(src)) {
                T nbrData = nbr.node;
                if (!vis.containsKey(nbrData)) {
                    dfs(nbrData, vis);
                }
            }
        }
    }
}