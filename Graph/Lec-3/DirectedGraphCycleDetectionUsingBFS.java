import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycleDetectionUsingBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topSortBFS(int n, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        // initilise kradi indegree sabki
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }
        // push all zero indegree wali node into queue
        for (int node = 0; node < n; node++) {
            if (indegree.getOrDefault(node, 0) == 0) {
                q.offer(node);
            }
        }

        // BFS chalate hai
        while (!q.isEmpty()) {
            int frontNode = q.poll();
            ans.add(frontNode);

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                indegree.put(nbr, indegree.get(nbr) - 1);

                // check for zero
                if (indegree.get(nbr) == 0) {
                    q.offer(nbr);
                }
            }
        }
    }

    public static boolean isCycle(int n) {
        List<Integer> ans = new ArrayList<>();
        topSortBFS(n, ans);
        return n == ans.size();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(3, 4, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(4, 6, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 7, true, adjList);
        g.printAdjList(adjList);
        if (isCycle(8)) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle present");
        }

        adjList = new HashMap<>();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(4, 3, true, adjList);
        g.addEdge(3, 5, true, adjList);
        g.addEdge(6, 4, true, adjList);
        g.addEdge(5, 6, true, adjList);
        g.addEdge(6, 7, true, adjList);
        g.printAdjList(adjList);
        if (isCycle(8)) {
            System.out.println("No Cycle");
        } else {
            System.out.println("Cycle present");
        }
    }
}