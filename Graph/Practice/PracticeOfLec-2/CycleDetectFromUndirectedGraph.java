import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectFromUndirectedGraph {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean checkCycleUndirectedGraghBFSHelper(int src, HashMap<Integer, Boolean> visited) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited.put(src, true);
        parent.put(src, -1);

        while (!q.isEmpty()) {
            int frontNode = q.poll();

            for (int nbr : adjList.get(frontNode)) {
                if (nbr == parent.get(frontNode)) {
                    continue;
                }

                if (!visited.containsKey(nbr)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                    parent.put(nbr, frontNode);
                } else if (visited.get(nbr)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkCycleUndirectedGraghBFS(int src) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < src; i++) {
            if (!visited.containsKey(i)) {
                if (checkCycleUndirectedGraghBFSHelper(src, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkCycleUndirectedGraghDFSHelper(int src, HashMap<Integer, Boolean> visited, int parent) {
        visited.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (nbr == parent) {
                continue;
            }
            if (!visited.containsKey(src)) {
                if (checkCycleUndirectedGraghDFSHelper(nbr, visited, src)) {
                    return true;
                }
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean checkCycleUndirectedGraghDFS(int src) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < src; i++) {
            if (!visited.containsKey(i)) {
                if (checkCycleUndirectedGraghDFSHelper(src, visited, -1)) {
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
        g.addEdge(3, 4, false, adjList);
        g.addEdge(2, 5, false, adjList);

        int src = 5;
        boolean isCylic = checkCycleUndirectedGraghDFS(src);
        if (isCylic) {
            System.out.println("Cycle Present");
        } else {
            System.out.println("Cycle Not Present");
        }
    }
}
