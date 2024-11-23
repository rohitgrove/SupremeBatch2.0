public class FindFirstOccrenceInSortedArray {
    public static int firstOccur(int arr[], int target) { // tc: O(logn), sc: O(1)
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            if (arr[mid] == target) {
                // ans store
                ans = mid;
                // left me jao
                e = mid - 1;
            } else if (target > arr[mid]) {
                // right me jao
                s = mid + 1;
            } else {
                // left me jao
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 30, 40, 50 };
        int target = 30;
        int ansIndex = firstOccur(arr, target);

        if (ansIndex == -1) {
            System.out.println("element not found");
        } else {
            System.out.println("element found at Index: " + ansIndex);
        }
    }
}
