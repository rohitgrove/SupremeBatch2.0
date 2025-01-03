public class PrintAllSubarrays {
    public static void printSubarr_util(int nums[], int start, int end) {
        // base case
        if (end == nums.length) {
            return;
        }

        // 1 case sol
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        printSubarr_util(nums, start, end + 1);
    }

    public static void printSubarr(int[] nums) {
        for (int start = 0; start < nums.length; start++) {
            int end = start;
            printSubarr_util(nums, start, end);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        printSubarr(nums);
    }
}
