import java.util.List;

public class Pair {
    public List<String> nodes;
    public int dist;

    public Pair(List<String> nodes, int dist) {
        this.dist = dist;
        this.nodes = nodes;
    }
}