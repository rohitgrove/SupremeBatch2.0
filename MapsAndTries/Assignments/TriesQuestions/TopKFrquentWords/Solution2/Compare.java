import java.util.Comparator;

public class Compare implements Comparator<Pair>{
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.freq == p2.freq) {
            return p1.word.compareTo(p2.word);
        } else {
            return p2.freq - p1.freq;
        }
    }
}
