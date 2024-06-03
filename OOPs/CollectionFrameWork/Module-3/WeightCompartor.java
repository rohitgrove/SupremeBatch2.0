import java.util.Comparator;

public class WeightCompartor implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        // return o2.weight - o1.weight;    
        return Integer.compare(o1.weight, o2.weight);
    }
}
