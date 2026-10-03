import java.util.ArrayList;
import java.util.List;

public class FindEvenNumbers {
    public static void evenElement(int arr[], int idx, List<Integer> even) {
        if (idx == arr.length) {
            return;
        }

        if (arr[idx] % 2 == 0) {
            even.add(arr[idx]);
        }

        evenElement(arr, idx + 1, even);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 11, 12, 13, 14 };
        List<Integer> ans = new ArrayList<>();
        evenElement(arr, 0, ans);
        System.out.println(ans);
    }
}
