import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    HashMap<Integer, List<Integer>> adjList = new HashMap<>();  
    
    public void addEdge(int u, int v, boolean direction) {
        adjList.putIfAbsent(u, new ArrayList<>());

        if (direction) {
            adjList.get(u).add(v);
        } else {
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
    
    public void adjListPrint() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey()+" -> { ");
            for (Integer values : entry.getValue()) {
                System.out.print(values + ", ");
            }
            System.out.println("}");
        }        
    }

    public void bfs(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited.put(src, true);

        while (!q.isEmpty()) {
            int frontNode = q.poll();
            System.out.print(frontNode + " ");

            for (Integer nbr : adjList.get(frontNode)) {
                if (!visited.getOrDefault(nbr, false)) {
                    q.add(nbr);
                    visited.put(nbr, true);
                }
            }
        }
    }

    public void dfs(int src, HashMap<Integer, Boolean> visited) {
        System.out.print(src + " ");
        visited.put(src, true);

        for (Integer nbr : adjList.get(src)) {
            if (!visited.getOrDefault(nbr, false)) {
                dfs(nbr, visited);
            }
        }
    }

    public boolean BFSUndirected(int src, HashMap<Integer, Boolean> visited) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        
        // Initial state
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
                } else if (visited.get(nbr) ) {
                    // Cycle present
                    return true;
                }
            }
        }
        // Cycle not present
        return false;
    }

    public boolean checkCycleUndirectedGraghBFS(int V) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < V; i++) {
            if (!visited.containsKey(i)) {
                boolean ans = BFSUndirected(i, visited);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFSUndirected(int src, Map<Integer, Boolean> vis, int parent) {
        vis.put(src, true);
        
        for (int nbr : adjList.get(src)) {
            if (!vis.containsKey(nbr)) {
                boolean ans = DFSUndirected(nbr, vis, src);
                if (ans) {
                    return true;
                }
            } else if (vis.get(nbr) && nbr != parent) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCycleUndirectedGraghDFS(int V) {
        HashMap<Integer, Boolean> vis = new HashMap<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis.containsKey(i)) {
                int parent = -1;
                boolean isCyclic = DFSUndirected(i, vis, parent);
                if (isCyclic) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFSDirected(int src, HashMap<Integer, Boolean> visited, HashMap<Integer, Boolean> dfsTrack) {
        visited.put(src, true);
        dfsTrack.put(src, true);

        for (int nbr : adjList.get(src)) {
            if (!visited.containsKey(nbr)) {
                boolean ans = DFSDirected(nbr, visited, dfsTrack);
                if (ans) {
                    return true;
                }
            } if (visited.get(nbr) && dfsTrack.get(nbr)) {
                // cycle present
                return true;
            }
        }

        // [backtrack] Yahi glati karta hu
        dfsTrack.put(src, false);
        return false;
    }  

    public boolean checkCycleDirectedGraghDFS(int V) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, Boolean> dfsTrack = new HashMap<>();

        for (int i = 0; i < V; i++) {
            if (!visited.containsKey(i)) {
                boolean isCyclic = DFSDirected(i, visited, dfsTrack);
                if (isCyclic) {
                    return true;
                }
            }
        }

        return false;
    }
}