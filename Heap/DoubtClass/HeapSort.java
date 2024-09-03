public class HeapSort {
    public static void heapify(int nums[], int idx, int n) {
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int swapindex = idx;
            if (left < n && nums[left] > nums[idx]) {
                swapindex = left;
            }
            
            if (right < n && nums[right] > nums[swapindex]) {
                swapindex = right;
            }
            
            if (swapindex == idx) {
                break;
            }

            int temp = nums[idx];
            nums[idx] = nums[swapindex];
            nums[swapindex] = temp;
            idx = swapindex;
        }
    }

    public static void buildHeap(int nums[], int n) {
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

    public static void printHeap(int arr[], int size) {
        for (int i = 1; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 10, 15, 20, 25, 12 };
        printHeap(arr, arr.length);
        sortArray(arr);
        printHeap(arr, arr.length);
    }
}