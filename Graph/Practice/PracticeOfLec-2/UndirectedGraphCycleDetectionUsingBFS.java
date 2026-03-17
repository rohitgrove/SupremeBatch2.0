import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphCycleDetectionUsingBFS {
    public static boolean checkCycleUtil(int src, HashMap<Integer, Boolean> vis, HashMap<Integer, List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        q.offer(src);
        vis.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            for (int nbr : adjList.get(frontNode)) {
                if (nbr == parent.get(frontNode)) {
                    continue;
                }

                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                    parent.put(nbr, frontNode);
                } else if (vis.get(nbr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCycle(int start, int end, HashMap<Integer, List<Integer>> adjList) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for (int src = start; src <= end; src++) {
            if (!vis.containsKey(src)) {
                if (checkCycleUtil(src, vis, adjList)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        Graph g = new Graph();
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(1, 3, false, adjList);

        g.addEdge(2, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        g.addEdge(3, 4, false, adjList);
        g.printAdj(adjList);

        if (checkCycle(0, 5, adjList)) {
            System.out.println("check karliya bhai, cycle hai bhai iss graph main");
        } else {
            System.out.println("check karliya bhai, cycle nhi hai bhai iss graph main");
        }
    }
}
