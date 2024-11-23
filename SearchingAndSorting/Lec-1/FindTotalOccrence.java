public class FindTotalOccrence {
    public static int firstOccur(int arr[], int target) {
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

    public static int lastOccur(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;

        while (s <= e) {
            if (arr[mid] == target) {
                // ans store
                ans = mid;
                // right me jao
                s = mid + 1;
            } else if (arr[mid] < target) {
                // right me jao
                s = mid + 1;
            } else if (arr[mid] > target) {
                // left me jao
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int findTotalOccrence(int ans[], int target) { // tc: O(logn), sc: O(1)
        int firstOccur = firstOccur(ans, target);
        int lastOccur = lastOccur(ans, target);
        return lastOccur - firstOccur + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 30, 40, 50 };
        int target = 30;
        int ans = findTotalOccrence(arr, target);
        System.out.println("Total occrence of " + target + " is: " + ans);
    }
}
