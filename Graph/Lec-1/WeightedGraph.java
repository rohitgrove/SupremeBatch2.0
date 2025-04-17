import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair<T> {
    public int wt;
    public T data;

    public Pair(T data, int wt) {
        this.wt = wt;
        this.data = data;
    }
}

public class WeightedGraph<T> {
    HashMap<T, List<Pair<T>>> adjList = new HashMap<>();

    public void addEdge(T u, T v, int wt, boolean direction) {
        // direction = false -> undirected
        // direction = true -> directed
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(new Pair<>(v, wt));
        } else {
            adjList.get(u).add(new Pair<>(v, wt));
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(new Pair<>(u, wt));
        }
    }

    public void printAdjList() {
        for (T src : adjList.keySet()) {
            System.out.print(src + " : { ");
            for (Pair<T> p : adjList.get(src)) {
                System.out.print("{" + p.data + ", " + p.wt + "}, ");
            }
            System.out.println("}");
        }
    }

    public void bfsTraversal(T src, HashMap<T, Boolean> visited) {
        // visited
        // queue
        // intital state
        Queue<T> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            // go to nbr
            for (Pair<T> nbr : adjList.get(frontNode)) {
                T nbrData = nbr.data;

                if (!visited.containsKey(nbrData)) {
                    q.offer(nbrData);
                    visited.put(nbrData, true);
                }
            }
        }
    }

    public void dfsTraversal(T src, HashMap<T, Boolean> visited) {
        visited.put(src, true);
        System.out.print(src + " ");

        if (!adjList.containsKey(src)) {
            for (Pair<T> nbr : adjList.get(src)) {
                T nbrData = nbr.data;
                if (!visited.containsKey(nbrData)) {
                    dfsTraversal(nbrData, visited);
                }
            }
        }
    }
}