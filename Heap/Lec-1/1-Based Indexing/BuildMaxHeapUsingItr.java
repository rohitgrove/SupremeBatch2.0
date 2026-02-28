public class BuildMaxHeapUsingItr {
    public static void heapify(int[] nums, int index, int n) {
        while (true) {
            int left = 2 * index;
            int right = 2 * index + 1;
            int largestindex = index;

            if (left <= n && nums[left] > nums[largestindex]) {
                largestindex = left;
            }

            if (right <= n && nums[right] > nums[largestindex]) {
                largestindex = right;
            }

            if (largestindex == index) {
                break;
            }

            int temp = nums[index];
            nums[index] = nums[largestindex];
            nums[largestindex] = temp;
            index = largestindex;
        }
    }

    public static void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i > 0; --i) {
            heapify(nums, i, n);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { -1, 5, 10, 15, 20, 25, 12 };
        System.out.println("Before heapify: ");
        printArr(arr);
        buildHeap(arr, arr.length - 1);
        System.out.println("After heapify: ");
        printArr(arr);
    }
}
