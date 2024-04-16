import java.util.List;
import java.util.ArrayList;

public class PrintIndexOfTarget {
    public static void printTarget1(int arr[], int target, int index) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            System.out.println(index);
        }

        printTarget1(arr, target, index + 1);
    }

    public static void printTarget2(int arr[], int target, int index, List<Integer> ans) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            ans.add(index);
        }

        printTarget2(arr, target, index + 1, ans);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 10, 30, 40 };
        int target = 10;
        printTarget1(arr, target, 0);
        List<Integer> ans = new ArrayList<>();
        printTarget2(arr, target, 0, ans);
        System.out.println(ans);
    }
}
