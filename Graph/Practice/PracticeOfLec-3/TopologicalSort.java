import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    
    public static void topSortdfsUtil(int src, HashMap<Integer, Boolean> visited, Stack<Integer> st) {
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    topSortdfsUtil(nbr, visited, st);                    
                }
            }
        }

        st.push(src);
    }

    public static List<Integer> topSortDFS(int n) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!visited.containsKey(i)) {
                topSortdfsUtil(i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public static List<Integer> topSortBFS(int n) {
        HashMap<Integer, Integer> inorder = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                inorder.putIfAbsent(nbr, 0);
                inorder.put(nbr, (inorder.get(nbr) + 1));
            }
        }

        for (int node = 0; node < n; node++) {
            if (inorder.containsKey(node) == false) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            ans.add(frontNode);

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                int count = inorder.get(nbr);
                inorder.put(nbr, count - 1);

                if (inorder.get(nbr) == 0) {
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
