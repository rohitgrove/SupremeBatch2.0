public class Solution6 {
    public static void selectionSort(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        int size = arr.length;
        
        System.out.println("Original Array:");
        printArray(arr);
        
        selectionSort(arr, size);
        
        System.out.println("Sorted Array:");
        printArray(arr);
    }

  
}
