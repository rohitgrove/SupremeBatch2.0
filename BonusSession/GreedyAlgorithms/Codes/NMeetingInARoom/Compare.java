import java.util.Comparator;

public class Compare implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.end == o2.end) {
            return o1.start - o2.start;
        } else {
            return o1.end - o2.end;
        }
    }
}
