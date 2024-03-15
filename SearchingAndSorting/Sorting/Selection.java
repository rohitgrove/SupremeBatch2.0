public class Selection {
    public static void selcetionSort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i; // ith element hi smallest hai
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            // swap ith and minIndex elements;
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = { 44, 33, 55, 22, 11 };
        selcetionSort(nums);
        printArr(nums);
    }
}
