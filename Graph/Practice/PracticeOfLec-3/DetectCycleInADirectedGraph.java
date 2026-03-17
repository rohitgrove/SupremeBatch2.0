import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topoSortUsingBFS(int n, List<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }

        for (int node = 0; node < n; node++) {
            if (!indegree.containsKey(node)) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            ans.add(frontNode);

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
    }

    public static boolean isCycle(int n) {
        List<Integer> ans = new ArrayList<>();
        topoSortUsingBFS(n, ans);
        return ans.size() == n;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, true, adjList);
        g.addEdge(1, 2, true, adjList);
        g.addEdge(2, 3, true, adjList);
        g.addEdge(3, 4, true, adjList);
        g.addEdge(4, 5, true, adjList);
        g.addEdge(5, 2, true, adjList);
        g.printAdj(adjList);

        if (isCycle(6)) {
            System.out.println("Bhai cycle hai nhi hai iss graph main");
        } else {
            System.out.println("Bhai cycle hai iss graph main");
        }
    }
}
