import java.util.Arrays;

public class TwoSum {
    public static boolean hasArrayTwoCandidates1(int[] arr, int n, int x) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasArrayTwoCandidates2(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int currSum = arr[l] + arr[h];
            if (currSum == x) {
                return true;
            } else if (currSum < x) {
                l++;
            } else {
                h--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int Arr[] = { 1, 4, 45, 6, 10, 8 };
        int N = Arr.length, X = 16;
        if (hasArrayTwoCandidates2(Arr, N, X)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
