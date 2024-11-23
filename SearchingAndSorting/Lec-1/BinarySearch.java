public class BinarySearch {
    public static int binarySearch(int arr[], int target) { // tc: O(logn), sc: O(1)
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            // found
            if (arr[mid] == target) {
                // return index of the found element
                return mid;
            } else if (target > arr[mid]) {
                // right me jao
                start = mid + 1;
            } else if (target < arr[mid]) {
                // left me jao
                end = mid - 1;
            }
            // mid update
            mid = start + (end - start) / 2;
        }

        // agar yaha tak pohoche ho
        // iska mtlb element nahi mila
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 70;
        int ansIndex = binarySearch(arr, target);

        if (ansIndex == -1) {
            System.out.println("element not found");
        } else {
            System.out.println("element found at Index: " + ansIndex);
        }
    }
}