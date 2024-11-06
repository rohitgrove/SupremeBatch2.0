public class SortColors {
    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void sortColors1(int[] nums) {
        int ones = 0;
        int twos = 0;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        int i = 0;
        while (zeros-- > 0) {
            nums[i] = 0;
            i++;
        }

        while (ones-- > 0) {
            nums[i] = 1;
            i++;
        }

        while (twos-- > 0) {
            nums[i] = 2;
            i++;
        }
    }

    public static void sortColors2(int nums[]) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColors2(nums);
        printArr(nums);
    }
}
