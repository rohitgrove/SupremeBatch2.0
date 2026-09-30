import java.util.Comparator;

public class Compare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        return str2.compareTo(str1);
    }
}
