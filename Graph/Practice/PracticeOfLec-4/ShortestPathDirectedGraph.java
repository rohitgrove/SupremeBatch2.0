import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ShortestPathDirectedGraph {
    static HashMap<Integer, List<Pair>> adjList = new HashMap<>();

    public static void topologicalSortUsingDFS(int src, HashMap<Integer, Boolean> vis, Stack<Integer> topoOrder) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (Pair nbr : adjList.get(src)) {
                int nbrData = nbr.data;
                if (!vis.containsKey(nbrData)) {
                    topologicalSortUsingDFS(nbrData, vis, topoOrder);
                }
            }
        }

        topoOrder.push(src);
    }

    public static void shortestPath(Stack<Integer> topoOrder, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int src = topoOrder.pop();
        dist[src] = 0;

        if (adjList.containsKey(src)) {
            for (Pair nbr : adjList.get(src)) {
                int nbrDist = nbr.dist;
                int nbrData = nbr.data;
                if (dist[src] + nbrDist < dist[nbrData]) {
                    dist[nbrData] = dist[src] + nbrDist;
                }
            }
        }

        while (!topoOrder.isEmpty()) {
            int srcNode = topoOrder.pop();

            if (!adjList.containsKey(srcNode)) {
                continue;
            }

            for (Pair nbr : adjList.get(srcNode)) {
                int nbrDist = nbr.dist;
                int nbrData = nbr.data;
                if (dist[srcNode] + nbrDist < dist[nbrData]) {
                    dist[nbrData] = dist[srcNode] + nbrDist;
                }
            }
        }

        System.out.println("Print all shortest distance: ");
        for (int ele : dist) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 5, true, adjList);
        g.addEdge(1, 3, 3, true, adjList);
        g.addEdge(0, 2, 3, true, adjList);
        g.addEdge(2, 4, 6, true, adjList);
        g.addEdge(2, 1, 2, true, adjList);
        g.addEdge(2, 3, 5, true, adjList);
        g.addEdge(4, 3, 1, true, adjList);
        g.printAdj(adjList);
        int src = 0;
        HashMap<Integer, Boolean> visted = new HashMap<>();
        Stack<Integer> topoOrder = new Stack<>();
        topologicalSortUsingDFS(src, visted, topoOrder);
        int n = 5;
        shortestPath(topoOrder, n);
    }
}
