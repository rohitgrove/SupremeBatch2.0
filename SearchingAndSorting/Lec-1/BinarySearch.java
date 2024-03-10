public class BinarySearch {
    public static int binarySearch(int arr[], int target) { // tc: O(logn)
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            // found
            if (arr[mid] == target) {
                // return index of the found element
                return mid;
            } else if (target > arr[mid]) {
                // right main jao
                s = mid + 1;
            } else {
                // left mai jao
                e = mid - 1;
            }

            // mid update
            mid = s + (e - s) / 2;
        }

        // agar yaha tak phoche ho
        // iska matlab element nhi mila tumhe
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 80;
        int ansIndex = binarySearch(arr, target);
        if (ansIndex == -1) {
            System.out.println("Element Not found");
        } else {
            System.out.println("Element found at index: "+ ansIndex);
        }
    }
}