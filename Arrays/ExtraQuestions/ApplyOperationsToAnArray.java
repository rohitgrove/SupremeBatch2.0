public class ApplyOperationsToAnArray {
    public static int[] applyOperations(int[] nums) {
        int i = 0;
        int j = i + 1;

        while (i <= nums.length - 2) {
            if (nums[i] == nums[j]) {
                nums[i] = nums[i] * 2;
                nums[j] = 0;
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return move(nums);
    }

    public static int[] move(int nums[]) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
        return nums;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 2, 1, 1, 0 };
        System.out.println("Before Aplly Operations");
        printArr(nums);
        System.out.println("After Aplly Operations");
        printArr(applyOperations(nums));
    }
}
