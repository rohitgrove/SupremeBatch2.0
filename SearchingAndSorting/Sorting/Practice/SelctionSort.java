public class SelctionSort {
    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public static void selcetionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }   
    }

    public static void main(String[] args) {
        int nums[] = { 44, 33, 55, 22, 11 };
        selcetionSort(nums);
        printArr(nums);
    }
}
