public class NearlySortedArray {
    public static int srachNearlySorted(int nums[], int target) { // tc: (logn)
        int s = 0;
        int e = nums.length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (mid - 1 >= 0 && nums[mid - 1] == target) {
                return mid - 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid+1] == target) {
                return mid + 1;
            } 

            if (target > nums[mid]) {
                // right
                s = mid + 2;
            } else {
                // left
                e = mid - 2;
            }

            mid = s + (e - s) / 2;
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 20, 10, 30, 50, 40, 70, 60 };
        int target = 20;

        int targetIndex = srachNearlySorted(arr, target);
        if (targetIndex != -1) {
            System.out.println("Element found at index: "+ targetIndex);
        } else {
            System.out.println("Element not found");
        }
    }
}
