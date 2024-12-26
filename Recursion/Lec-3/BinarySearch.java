public class BinarySearch {
    public static int binarySearch(int arr[], int s, int e, int target) {
        // base case
        if (s > e) {
            // element not found
            return -1;
        }

        // processing -> 1 case khud solve kro
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        // baaki recursion sumbhal lega
        if (arr[mid] < target) {
            // right me jao
            return binarySearch(arr, mid + 1, e, target);
        } else {
            // left me jao
            return binarySearch(arr, s, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
        System.out.println(binarySearch(arr, 0, arr.length - 1, 70));
    }
}
