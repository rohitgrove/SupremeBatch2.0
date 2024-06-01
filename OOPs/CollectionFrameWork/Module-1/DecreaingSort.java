import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DecreaingSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);
        // Accending Sort
        Collections.sort(list);
        System.out.println("Accending Sorting Using Sort Function: " + list);

        // decreasing Method
        list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);
        // cutom Comparator
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println("Decreasing Sorting Using Custom Comparator: " + list);

        list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);

        // labda expression
        Collections.sort(list,(o1, o2) -> o2 - o1);
        // list.sort((o1, o2) -> o2 - o1);
        System.out.println("Decreasing Sorting Using Lambda Expression: " + list);

        list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Decreasing Sorting Using reverseOrder Function: " + list);
    }
}
