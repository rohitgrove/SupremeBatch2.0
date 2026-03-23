public class SortColors {
    public static void sortColors1(int[] nums) {
        // count method
        int zeros, ones, twos;
        zeros = ones = twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        // spread
        int i = 0;
        while (zeros > 0) {
            nums[i] = 0;
            zeros--;
            i++;
        }

        while (ones > 0) {
            nums[i] = 1;
            ones--;
            i++;
        }

        while (twos > 0) {
            nums[i] = 2;
            twos--;
            i++;
        }
    }

    public static void sortColors2(int[] nums) {
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

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColors2(nums);
        printArr(nums);
    }
}
