import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphWithWeight<T> {
    static class Pair<T> {
        T node;
        int wt;

        public Pair(T node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public HashMap<T, List<Pair<T>>> adjList = new HashMap<>();

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
            System.out.print(src + " : { ");
            for (Pair<T> nbr : adjList.get(src)) {
                System.out.print("{ " + nbr.node + " : " + nbr.wt + " }, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }

    public void dfs(T src, HashMap<T, Boolean> visited) {
        System.out.print(src + " ");
        visited.put(src, true);
        
        if (!visited.containsKey(src)) {
            for (Pair<T> nbr : adjList.get(src)) {
                T nbrData = nbr.node;
                dfs(nbrData, visited);
            }
        }
    }

    public void bfs(T src, HashMap<T, Boolean> vis) {
        Queue<T> q = new LinkedList<>();
        q.add(src);

        vis.put(src, true);

        while (!q.isEmpty()) {
            T frontNode = q.poll();
            System.out.print(frontNode+" ");

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
}
