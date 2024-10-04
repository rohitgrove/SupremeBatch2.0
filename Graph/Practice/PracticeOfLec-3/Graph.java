import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class Graph {
    public HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdges(int u, int v, boolean direction) {
        adjList.putIfAbsent(u, new ArrayList<>());

        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public void printList() {
        for (int src : adjList.keySet()) {
            System.out.print(src + " ");
            for (Integer element : adjList.get(src)) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public void printBFS(int start, int end) {
        HashMap<Integer, Boolean> visi = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visi.containsKey(node)) {
                bfs(node, visi);
            }
        }
    }

    public void dfs(int src, HashMap<Integer, Boolean> visited) {
        System.out.print(src + " ");
        visited.put(src, true);

        if (adjList.containsKey(src)) {
            for (int nbr : adjList.get(src)) {
                if (!visited.containsKey(nbr)) {
                    dfs(nbr, visited);
                }
            }
        }
    }

    public void printDFS(int start, int end) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int node = start; node <= end; node++) {
            if (!visited.containsKey(node)) {
                dfs(node, visited);
            }
        }
    }

    public void topSortDFS(int end) {
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

    public void topSortDFSUtil(int src, HashMap<Integer, Boolean> vis, Stack<Integer> s) {
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

    public List<Integer> topSortBFS(int n) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : adjList.keySet()) {
            for (int nbr : adjList.get(i)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        }
    
        for (int node = 0; node < n; node++) {
            if (indegree.containsKey(node) == false) {
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
                int count = indegree.get(nbr);
                indegree.put(nbr, count - 1);

                if (indegree.get(nbr) == 0) {
                    q.add(nbr);
                }
            }
        }

        return ans;
    }

    public boolean checkCycleDirectedGraghBFS(int n) {
        if (n == topSortBFS(n).size()) {
            return false;
        } else {
            return true;
        }
    }

    public List<Integer> shortestPathBFS(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            if (!adjList.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    parent.put(nbr, frontNode);
                    visited.put(nbr, true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (dest != -1) {
            ans.add(dest);
            dest = parent.get(dest);
        }

        Collections.reverse(ans);
        return ans;
    }
}