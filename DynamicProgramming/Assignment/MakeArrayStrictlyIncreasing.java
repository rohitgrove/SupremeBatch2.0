import java.util.Arrays;
import java.util.HashMap;

public class MakeArrayStrictlyIncreasing {
    static final int INF = (int) 1e9 + 1;

    public static int solveUsingRec(int[] arr1, int[] arr2, int prev, int curr) {
        if (curr == arr1.length) {
            return 0;
        }

        int op1 = INF;
        if (prev < arr1[curr]) {
            op1 = solveUsingRec(arr1, arr2, arr1[curr], curr + 1); // no-op
        }

        int op2 = INF;
        int index = Arrays.binarySearch(arr2, prev + 1); // Searching for upper bound
        if (index < 0)
            index = Math.abs(index) - 1; // Handling the upper bound behavior in binary search

        if (index < arr2.length) {
            op2 = 1 + solveUsingRec(arr1, arr2, arr2[index], curr + 1);
        }

        return Math.min(op1, op2);
    }

    public static int solveUsingMemo(int[] arr1, int[] arr2, int prev, int curr, HashMap<String, Integer> dp) {
        if (curr == arr1.length) {
            return 0;
        }

        // Create a key for the current state
        String key = prev + "," + curr;

        // Check if the result for the current state is already computed
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int op1 = INF;
        if (prev < arr1[curr]) {
            op1 = solveUsingMemo(arr1, arr2, arr1[curr], curr + 1, dp); // no-op
        }

        int op2 = INF;
        int index = Arrays.binarySearch(arr2, prev + 1); // Searching for upper bound
        if (index < 0)
            index = Math.abs(index) - 1; // Handling the upper bound behavior in binary search

        if (index < arr2.length) {
            op2 = 1 + solveUsingMemo(arr1, arr2, arr2[index], curr + 1, dp);
        }

        // Store the result in the memo map
        int result = Math.min(op1, op2);
        dp.put(key, result);

        return result;
    }

    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);  // Sort arr2 to maintain the upper bound search

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
