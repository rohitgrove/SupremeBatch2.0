public class CheckSortedOrNot {
    public static boolean checkSorted(int arr[], int size, int idx) {
        // base case
        if (idx >= size) {
            return true;
        }

        // processing
        if (arr[idx] > arr[idx - 1]) {
            // aage check krna padega
            // ab recursion sumbhalega
            return checkSorted(arr, size, idx + 1);
        } else {
            // sorted nhi hai
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 50, 60, 70 };
        boolean ans = checkSorted(arr, arr.length, 1);
        if (ans) {
            System.out.println("Array is Sorted");
        } else {
            System.out.println("Array is not Sorted");
        }
    }
}