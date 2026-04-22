public class MoveZero {
    public static void moveZeroes1(int[] nums) {
        int result[] = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        moveZeroes2(nums);
        printArr(nums);
    }
}