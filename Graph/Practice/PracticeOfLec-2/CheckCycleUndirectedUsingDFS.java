import java.util.HashMap;
import java.util.List;

public class CheckCycleUndirectedUsingDFS {
    public static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static boolean checkCycleUndirectedGraghDFSUtil(int src, HashMap<Integer, Boolean> visited, int parent) {
        visited.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (nbr == parent) {
                continue;
            }
            if (!visited.containsKey(src)) {
                boolean ans = checkCycleUndirectedGraghDFSUtil(nbr, visited, src);
                if(ans) {
                    return true;
                }
            } else if (visited.get(src)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkCycleUndirectedGraghDFS(int src) {
        HashMap<Integer, Boolean> visited = new HashMap<>();

        for (int node = 0; node <= src; node++) {
            if (!visited.containsKey(node)) {
                int parent = -1;
                boolean ans = checkCycleUndirectedGraghDFSUtil(src, visited, parent);
                if (ans) {
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
