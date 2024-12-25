import java.util.ArrayList;
import java.util.List;

public class FindEvenNumbers {
    public static void findEvenNumbers(int arr[], int idx, List<Integer> even) {
        // base case
        if (idx == arr.length) {
            return;
        }
        // processing
        if (arr[idx] % 2 == 0) {
            // even
            even.add(arr[idx]);
        }

        // recursive call
        findEvenNumbers(arr, idx + 1, even);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 11, 12, 13, 14 };
        List<Integer> even = new ArrayList<>();
        findEvenNumbers(arr, 0, even);
        System.out.println(even);
    }
}
