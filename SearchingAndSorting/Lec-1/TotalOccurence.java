public class TotalOccurence {
    public static int firstOccur(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] == target) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int lastOccur(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] == target) {
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int totalOccur(int arr[], int target) { // tc: O(logn)
        int first = firstOccur(arr, target);
        int last = lastOccur(arr, target);
        int ans = last - first + 1;
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 40, 50 };
        System.out.println(totalOccur(arr, 30));
    }
}
