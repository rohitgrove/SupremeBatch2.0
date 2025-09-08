import java.util.Arrays;

public class TwoSum {
    public static boolean twoSum(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean twoSum2PointerApproach(int arr[], int n, int x) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int currSum = arr[low] + arr[high];
            if (currSum == x) {
                return true;
            } else if (currSum > x) {
                high--;
            } else {
                low++;
            }
        }

        return false;
    }

    public static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        return twoSum2PointerApproach(arr, n, x);
    }

    public static void main(String[] args) {
        int Arr[] = { 1, 4, 45, 6, 10, 8 };
        int N = Arr.length, X = 16;
        System.out.println(hasArrayTwoCandidates(Arr, N, X));
    }
}
