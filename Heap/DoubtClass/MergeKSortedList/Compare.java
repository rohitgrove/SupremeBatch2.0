import java.util.Comparator;

public class Compare implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.val - o2.val;
    }
}
