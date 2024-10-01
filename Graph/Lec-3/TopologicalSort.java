import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void topSortDFS(int end) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < end; i++) {
            if (!vis.containsKey(i)) {
                topSortDFSUtil(i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortDFSUtil(int src, HashMap<Integer, Boolean> vis, Stack<Integer> s) {
        vis.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!vis.containsKey(nbr)) {
                    topSortDFSUtil(nbr, vis, s);
                }
            }
        }
        s.push(src);
    }

    public static List<Integer> topSortBFS(int n) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // Initialize indegree of all nodes
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            for (int nbr : entry.getValue()) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }
        // push all zero indegree will node into queue
        for (int node = 0; node < n; node++) {
            if (indegree.containsKey(node) == false) {
                q.add(node);
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
                int count = indegree.get(nbr);
                indegree.put(nbr, count - 1);

                // check zero
                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        return ans;
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
        g.addEdge(6, 7, true, adjList);

        // g.printList();
        // g.topSortDFS(8);
        int n = 8;
        System.out.println(topSortBFS(n));
    }
}
