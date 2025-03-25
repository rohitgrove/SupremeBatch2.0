import java.util.Comparator;

public class Compare implements Comparator<Pair<Double, Pair<Integer, Integer>>> {
    @Override
    public int compare(Pair<Double, Pair<Integer, Integer>> p1, Pair<Double, Pair<Integer, Integer>> p2) {
        return Double.compare(p2.key, p1.key); // max-heap
    }
}
