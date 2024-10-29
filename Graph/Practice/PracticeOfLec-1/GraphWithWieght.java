import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

class Pair<T> {
    public T data;
    public int wt;

    public Pair(T data, int wt) {
        this.data = data;
        this.wt = wt;
    }
}

public class GraphWithWieght<T> {
    public HashMap<T, List<Pair<T>>> adjList = new HashMap<>();

    public void addEdge(T u, T v, int wt, boolean direction) {
        adjList.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adjList.get(u).add(new Pair<>(u, wt));
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(new Pair<>(u, wt));
            adjList.get(v).add(new Pair<>(v, wt));
        }
        printAdj();
    }

    public void printAdj() {
        for (T src : adjList.keySet()) {
            System.out.print(src + " -> {");
            for (Pair<T> neighbour : adjList.get(src)) {
                System.out.print("{ " + neighbour.data + ", " + neighbour.wt + "}, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void bfsTraversal(T src) {
        Queue<T> q = new LinkedList<>();
        HashMap<T, Boolean> visited = new HashMap<>();
        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (Pair<T> nbr : adjList.get(frontNode)) {
                T nbrData = nbr.data;
                if (!visited.containsKey(nbrData)) {
                    q.add(nbrData);
                    visited.put(nbrData, true);
                }
            }
        }
    }

    public void dfsTraversal(T src, HashMap<T, Boolean> visited) {
        System.out.print(src + " ");
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (Pair<T> nbr : adjList.get(src)) {
                T nbrData = nbr.data;
                if (!visited.containsKey(nbrData)) {
                    dfsTraversal(nbrData, visited);
                }
            }
        }
    }
}