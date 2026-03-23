import java.util.Arrays;
import java.util.HashMap;

public class MakeArrayStrictlyIncreasing {
    static final int INF = (int) 1e9 + 1;

    public static int solveUsingRecursion(int[] arr1, int[] arr2, int prev, int idx) {
        if (idx == arr1.length) {
            return 0;
        }

        int op1 = INF;
        if (prev < arr1[idx]) {
            op1 = solveUsingRecursion(arr1, arr2, arr1[idx], idx + 1); // no-op
        }

        int op2 = INF;
        int index = Arrays.binarySearch(arr2, prev + 1); // Searching for upper bound
        if (index < 0) {
            index = Math.abs(index) - 1; // Handling the upper bound behavior in binary search
        }

        if (index < arr2.length) {
            op2 = 1 + solveUsingRecursion(arr1, arr2, arr2[index], idx + 1);
        }

        return Math.min(op1, op2);
    }

    public static int solveUsingMemo(int[] arr1, int[] arr2, int prev, int idx, HashMap<String, Integer> dp) {
        if (idx == arr1.length) {
            return 0;
        }

        if (dp.containsKey(prev + "" + idx)) {
            return dp.get(prev + "" + idx);
        }

        int op1 = INF;
        if (prev < arr1[idx]) {
            op1 = solveUsingMemo(arr1, arr2, arr1[idx], idx + 1, dp); // no-op
        }

        int op2 = INF;
        int index = Arrays.binarySearch(arr2, prev + 1); // Searching for upper bound
        if (index < 0) {
            index = Math.abs(index) - 1; // Handling the upper bound behavior in binary search
        }

        if (index < arr2.length) {
            op2 = 1 + solveUsingMemo(arr1, arr2, arr2[index], idx + 1, dp);
        }

        dp.put(prev + "" + idx, Math.min(op1, op2));
        return dp.get(prev + "" + idx);
    }

    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        HashMap<String, Integer> dp = new HashMap<>();
        int ans = solveUsingMemo(arr1, arr2, -1, 0, dp);
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 5, 3, 6, 7 }, arr2[] = { 1, 3, 2, 4 };
        System.out.println(makeArrayIncreasing(arr1, arr2));
        int arr3[] = { 1, 5, 3, 6, 7 }, arr4[] = { 4, 3, 1 };
        System.out.println(makeArrayIncreasing(arr3, arr4));
        int arr5[] = { 1, 5, 3, 6, 7 }, arr6[] = { 1, 6, 3, 3 };
        System.out.println(makeArrayIncreasing(arr5, arr6));
    }
}
