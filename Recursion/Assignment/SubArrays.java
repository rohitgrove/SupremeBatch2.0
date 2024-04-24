public class SubArrays {
    public static void printSubarray_util(int nums[], int start, int end) {
        if (end == nums.length) {
            return;
        }
        // 1 case sol
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        printSubarray_util(nums, start, end + 1);
    }

    public static void printSubarray(int nums[]) {
        for (int start = 0; start < nums.length; start++) {
            int end = start;
            printSubarray_util(nums, start, end);
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        printSubarray(nums);
    }
}
