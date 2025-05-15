import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DirectedShortestPath {
    public static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void topoOrder(int src, Stack<Integer> topoOrder, HashMap<Integer, Boolean> vis) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (Pair nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr.data)) {
                    topoOrder(nbr.data, topoOrder, vis);
                }
            }
        }

        topoOrder.push(src);
    }

    public static void shortestPathDFS(Stack<Integer> topoOrder, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int src = topoOrder.pop();
        dist[src] = 0;

        if (!adjList.containsKey(src)) {
            return;
        }

        for (Pair nbr : adjList.get(src)) {
            int nbrNode = nbr.data;
            int nbrDist = nbr.dist;
            if (dist[src] + nbrDist < dist[nbrNode]) {
                dist[nbrNode] = dist[src] + nbrDist;
            }
        }

        while (!topoOrder.isEmpty()) {
            src = topoOrder.pop();

            if (!adjList.containsKey(src)) {
                continue;
            }

            for (Pair nbr : adjList.get(src)) {
                int nbrNode = nbr.data;
                int nbrDist = nbr.dist;
                if (dist[src] + nbrDist < dist[nbrNode]) {
                    dist[nbrNode] = dist[src] + nbrDist;
                }
            }
        }

        System.out.println("Printing the distance array");
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge(0, 1, 5, true, adjList);
        g.addEdge(0, 2, 3, true, adjList);

        g.addEdge(1, 3, 3, true, adjList);

        g.addEdge(2, 1, 2, true, adjList);
        g.addEdge(2, 3, 5, true, adjList);
        g.addEdge(2, 4, 6, true, adjList);

        g.addEdge(4, 3, 1, true, adjList);

        g.printAdjList(adjList);

        int src = 0;
        Stack<Integer> topoOrder = new Stack<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();
        topoOrder(src, topoOrder, vis);

        // System.out.println("printing topo order");
        // while (!topoOrder.isEmpty()) {
        // System.out.print(topoOrder.pop() + " ");
        // }

        int n = 5;
        shortestPathDFS(topoOrder, n);
    }
}
