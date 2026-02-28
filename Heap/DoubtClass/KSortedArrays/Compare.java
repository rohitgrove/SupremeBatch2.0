import java.util.Comparator;

public class Compare implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return o1.data - o2.data;
    }
}