import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair<T> {
    public T node;
    public int wt;

    public Pair(T node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

public class WeightedGraph<T> {
    HashMap<T, List<Pair<T>>> adjList = new HashMap<>();

    public void addEdge(T u, T v, int wt, boolean direction) {
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
            System.out.print(src + " -> {");
            for (Pair<T> nbr : adjList.get(src)) {
                System.out.print("{" + nbr.node + ", " + nbr.wt + "}, ");
            }
            System.out.println("}");
        }
    }

    public void bfsTraversal(T src, HashMap<T, Boolean> vis) {
        Queue<T> q = new LinkedList<>();
        q.offer(src);
        vis.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (Pair<T> nbr : adjList.get(frontNode)) {
                if (!vis.containsKey(nbr.node)) {
                    q.offer(nbr.node);
                    vis.put(nbr.node, true);
                }
            }
        }
    }

    public void dfsTraversal(T src, HashMap<T, Boolean> vis) {
        vis.put(src, true);
        System.out.print(src + " ");

        if (adjList.containsKey(src)) {
            for (Pair<T> nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr.node)) {
                    dfsTraversal(nbr.node, vis);
                }
            }
        }
    }
}
