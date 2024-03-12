public class TotalOccurence {
    public static int totalOccur(int nums[], int target) {
        int firstOccurr = firstOccur(nums, target);
        int lastOccurr = lastOccur(nums, target);
        int ans = lastOccurr - firstOccurr + 1;
        return ans;
    }

    public static int firstOccur(int nums[], int target) {
        int s = 0;
        int e = nums.length -1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (nums[mid] == target) {
                e = mid - 1;
                ans = mid;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        return ans;
    }

    public static int lastOccur(int nums[], int target) {
        int s = 0;
        int e = nums.length -1;
        int ans = -1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (nums[mid] == target) {
                s = mid + 1;
                ans = mid;
            } else if (nums[mid] < target) {
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
        System.out.println(totalOccur(arr, 30));
    }    
}
