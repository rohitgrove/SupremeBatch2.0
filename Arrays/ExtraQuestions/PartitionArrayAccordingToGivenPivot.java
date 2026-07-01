public class PartitionArrayAccordingToGivenPivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        int i = 0;
        int j = n - 1;

        while (i < n) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }

            i++;
            j--;
        }

        // Remaining positions contain pivot
        while (left <= right) {
            ans[left++] = pivot;
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 9, 12, 5, 10, 14, 3, 10 };
        printArr(nums);
        printArr(pivotArray(nums, 10));
    }
}
