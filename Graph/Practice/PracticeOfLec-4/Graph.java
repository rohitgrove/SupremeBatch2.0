import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// directed and weighted
public class Graph {
    public void addEdge(int u, int v, int wt, boolean direction, HashMap<Integer, List<Pair>> adj) {
        // direction - false - undirected
        // direction - true - directed

        adj.putIfAbsent(u, new ArrayList<>());
        if (direction) {
            adj.get(u).add(new Pair(v, wt));
        } else {
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
    }

    public void printAdj(HashMap<Integer, List<Pair>> adj) {
        for (int src : adj.keySet()) {
            System.out.print(src + ": { ");
            for (Pair nbr : adj.get(src)) {
                System.out.print("{" + nbr.node + ", " + nbr.dist + "}, ");
            }
            System.out.println("}");
        }
        System.out.println();
    }
}