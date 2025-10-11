import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphDetectCycleUsingBFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean cycleDetect(int src, HashMap<Integer, Boolean> vis) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        q.offer(src);
        vis.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int srcNode = q.poll();

            for (int nbr : adjList.get(srcNode)) {
                if (nbr == parent.get(srcNode)) {
                    continue;
                }

                if (!vis.containsKey(nbr)) {
                    q.offer(nbr);
                    vis.put(nbr, true);
                    parent.put(nbr, srcNode);
                } else if (vis.containsKey(nbr)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCylic(int src) {
        HashMap<Integer, Boolean> vis = new HashMap<>();

        for (int node = 0; node < src; node++) {
            if (!vis.containsKey(node)) {
                if (cycleDetect(node, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, false, adjList);
        g.addEdge(1, 2, false, adjList);
        g.addEdge(1, 3, false, adjList);

        g.addEdge(2, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        g.addEdge(3, 4, false, adjList);

        int src = 6;
        boolean isCylic = isCylic(src);
        if (isCylic) {
            System.out.println("Cycle Present hai");
        } else {
            System.out.println("Cycle Present nhi hai");
        }
    }
}
