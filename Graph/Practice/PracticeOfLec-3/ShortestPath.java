import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Stack;

public class ShortestPath {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    public static void shortestPathBFS(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            if (!visited.containsKey(frontNode)) {
                continue;
            }

            for (int nbr : adjList.get(frontNode)) {
                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                    parent.put(nbr, frontNode);
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        while (dest != -1) {
            st.push(dest);
            dest = parent.get(dest);
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 5, false, adjList);
        g.addEdge(5, 4, false, adjList);
        g.addEdge(4, 3, false, adjList);
        g.addEdge(0, 6, false, adjList);
        g.addEdge(6, 3, false, adjList);
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(2, 3, false, adjList);
        g.printAdj(adjList);
        int src = 0;
        int dest = 3;
        shortestPathBFS(src, dest); 

        adjList.clear();
        Graph g1 = new Graph();
        g1.addEdge(0, 4, false, adjList);
        g1.addEdge(4, 1, false, adjList);
        g1.addEdge(1, 5, false, adjList);
        g1.addEdge(0, 3, false, adjList);
        g1.addEdge(3, 5, false, adjList);
        g1.addEdge(0, 6, false, adjList);
        g1.addEdge(6, 2, false, adjList);
        g1.addEdge(2, 5, false, adjList);
        g1.printAdj(adjList);
        src = 0;
        dest = 5;
        shortestPathBFS(src, dest); 
    }
}