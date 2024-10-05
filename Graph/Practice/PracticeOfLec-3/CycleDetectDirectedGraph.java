import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class CycleDetectDirectedGraph {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    
    public static List<Integer> topoSort(int n) {
        Queue<Integer> q = new LinkedList<>();  
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int src : adjList.keySet()) {
            for (int nbr : adjList.get(src)) {
                indegree.putIfAbsent(nbr, 0);
                indegree.put(nbr, indegree.get(nbr) + 1);
            }
        } 

        for (int node = 0; node < n; node++) {
            if (indegree.containsKey(node) == false) {
                q.add(node);
            }
        }

        List<Integer> ans = new ArrayList<>();

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

    public static boolean checkCycleDirectedGraghBFS(int n) {
        if (topoSort(n).size() == n) {
            return false;
        } else {
            return true;
        }
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

        int n = 8;
        System.out.println(checkCycleDirectedGraghBFS(n));

        Graph g1 = new Graph();
        g1.addEdge(0, 1, true, adjList);
        g1.addEdge(1, 2, true, adjList);
        g1.addEdge(2, 3, true, adjList);
        g1.addEdge(3, 4, true, adjList);
        g1.addEdge(4, 5, true, adjList);
        g1.addEdge(5, 2, true, adjList);

        int n1 = 6;
        System.out.println(checkCycleDirectedGraghBFS(n1));
    }   
}
