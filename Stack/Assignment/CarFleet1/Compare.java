import java.util.Comparator;

public class Compare implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.pos - o2.pos;
    }
}
