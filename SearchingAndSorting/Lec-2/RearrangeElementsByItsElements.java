public class RearrangeElementsByItsElements {
    public static int[] rearrangeArray(int[] nums) {
        int ans[] = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                ans[even] = num;
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, -2, -5, 2, -4 };
        printArr(nums1);
        printArr(rearrangeArray(nums1));
        int nums2[] = { -1, 1 };
        printArr(nums2);
        printArr(rearrangeArray(nums2));
    }
}
