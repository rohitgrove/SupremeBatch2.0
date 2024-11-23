public class FindLastOccrenceInSortedArray {
    public static int lastOccur(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            if (arr[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else if (arr[mid] > target) {
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 30, 40, 50 };
        int target = 30;
        int ansIndex = lastOccur(arr, target);
        if (ansIndex == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + ansIndex);
        }
    }
}
