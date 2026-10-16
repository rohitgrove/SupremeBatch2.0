public class CheckArraySortedOrNot {
    public static boolean solve(int arr[], int idx) {
        if (idx >= arr.length) {
            return true;
        }

        if (arr[idx] >= arr[idx - 1]) {
            return solve(arr, idx + 1);
        } else {
            return false;
        }
    }

    public static boolean isSorted(int[] arr) {
        return solve(arr, 1);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        System.out.println(isSorted(arr));
    }
}
