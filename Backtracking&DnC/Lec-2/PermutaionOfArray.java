public class PermutaionOfArray {
    public static void permute(int[] nums) {
        int index = 0;
        solve(nums, index);
    }

    public static void solve(int nums[],  int index) {
        if (index >= nums.length) {
            printArr(nums);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            solve(nums, index + 1);
            swap(nums, index, i);
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        permute(nums1);
    }
}
