public class PrintAllSubArray {
    public static void subArray_util(int nums[], int start, int end) {
        if (end == nums.length) {
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        subArray_util(nums, start, end + 1);
    }
    public static void subArray(int nums[]) {
        for (int start = 0; start < nums.length; start++) {
            int end = start;
            subArray_util(nums, start, end);
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        subArray(nums);
    }
}
