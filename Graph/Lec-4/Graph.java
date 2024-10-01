import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        for (Map.Entry<Integer, List<Pair>> entry : adj.entrySet()) {
            System.out.print(entry.getKey() + " : {");
            for (Pair nbr : entry.getValue()) {
                System.out.print("{" + nbr.node + " , " + nbr.dist + "},");
            }
            System.out.println("} ");
        }
    }
}