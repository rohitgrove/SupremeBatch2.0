import java.util.Comparator;

public class Compare implements Comparator<Info> {
    @Override
    public int compare(Info a, Info b) {
        return b.count - a.count;
    }
}
