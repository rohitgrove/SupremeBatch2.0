public class SortColors {
    public static void sortColors(int[] nums) {
        int index = 0;
        int left = 0;
        int right = nums.length - 1;

        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left++;
                index++;
            } else if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right] = temp;
                // catch -> no need of index++
                // index++
                right--;
            } else {
                index++;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums1);
        printArr(nums1);
        int nums2[] = { 2, 0, 1 };
        sortColors(nums2);
        printArr(nums2);
    }
}
