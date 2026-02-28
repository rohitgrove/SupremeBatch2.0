public class CountZeroAndOnes {
    public static void countZeroOne(int[] arr, int n) {
        int zeroCount = 0;
        int oneCount = 0;

        // Count 0s and 1s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else if (arr[i] == 1) {
                oneCount++;
            }
        }

        System.out.println("Zero Counts: " + zeroCount);
        System.out.println("One Counts: " + oneCount);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
        int n = 14;
        countZeroOne(arr, n);
        printArr(arr);
    }
}
