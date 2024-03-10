public class FindFirstOccurence {
    public static int findFirstOccur(int arr[], int target) { // tc: O(logn)
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
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

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 30, 30, 40, 50 };
        System.out.println(findFirstOccur(arr, 30));
    }
}
