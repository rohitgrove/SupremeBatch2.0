import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class TopologicalSortBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topologicalSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int srcNode : adjList.keySet()) {
            for (int nbrNode : adjList.get(srcNode)) {
                indegree.putIfAbsent(nbrNode, 0);
                indegree.put(nbrNode, indegree.get(nbrNode) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!indegree.containsKey(i)) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(2, 4, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(5, 7, true, adjList);
        g.printAdjList(adjList);
        topologicalSort(8);

        adjList = new HashMap<>();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(3, 4, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(4, 6, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 7, true, adjList);
        g.printAdjList(adjList);
        topologicalSort(8);
    }
}
