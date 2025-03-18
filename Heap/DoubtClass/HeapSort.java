public class HeapSort {
    public static void heapify(int[] nums, int i, int n) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int swapindex = i;

            if (left < n && nums[left] > nums[i]) {
                swapindex = left;
            }

            if (right < n && nums[right] > nums[swapindex]) {
                swapindex = right;
            }

            if (swapindex == i) {
                break;
            }

            int temp = nums[i];
            nums[i] = nums[swapindex];
            nums[swapindex] = temp;
            i = swapindex;
        }
    }

    public static void buildHeap(int[] nums, int n) {
        for (int i = (n / 2) - 1; i >= 0; --i) {
            heapify(nums, i, n);
        }
    }

    public static void heapSort(int[] nums) {
        int n = nums.length - 1;
        while (n > 0) {
            // swap element to last
            int temp = nums[0];
            nums[0] = nums[n];
            nums[n] = temp;
            heapify(nums, 0, n);
            n--;
        }
    }

    public static int[] sortArray(int[] nums) {
        buildHeap(nums, nums.length);
        heapSort(nums);
        return nums;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 5, 2, 3, 1 };
        printArr(sortArray(nums));
    }
}