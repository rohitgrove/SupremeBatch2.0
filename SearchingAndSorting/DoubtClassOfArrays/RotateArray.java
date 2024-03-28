public class RotateArray {
    public static void rotate1(int[] nums, int rot) { // tc: O(n2)
        rot = rot % nums.length;
        if (rot < 0) {
            rot = rot + nums.length;
        }

        for (int i = 1; i <= rot; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotate2(int nums[], int rot) {
        rot = rot % nums.length;
        if (rot < 0) {
            rot += nums.length;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rot - 1);
        reverse(nums, rot, nums.length - 1);
    }

    public static void reverse(int nums[], int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 }, k = -3;
        rotate2(nums, k);
        printArr(nums);
    }
}
