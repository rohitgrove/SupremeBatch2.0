import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = { 5, 1, 7, 2, 8, 4 };
        Arrays.sort(arr, new ReverseCmp());
        for (int a : arr) {
            System.out.print(a + " ");
        }

        // List<Student> students = new ArrayList<>();
        // students.add(new Student(19, "Vipul", 68));
        // students.add(new Student(23, "Love", 87));
        // students.add(new Student(23, "Ankit", 55));
        // students.add(new Student(7, "Billu", 13));

        // System.out.println(students);

        // Collections.sort(students, new Comparator<Student>() {
        // @Override
        // public int compare(Student s1, Student s2) {
        // return s2.weight - s1.weight;
        // }
        // });

        // Collections.sort(students, new WeightCompartor());
        // Collections.sort(students, (s1, s2) -> s2.weight - s1.weight);

        // System.out.println(students);
        // List<Integer> list = new ArrayList<>();
        // list.add(15);
        // list.add(8);
        // list.add(2);
        // list.add(98);

        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
    }
}
