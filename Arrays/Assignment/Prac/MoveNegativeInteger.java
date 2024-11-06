public class MoveNegativeInteger {
    public static int[] separateNegativeAndPositive(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] < 0) {
                low++;
            } else if (arr[high] > 0) {
                high--;
            } else {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        return arr;
    }   
    
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int arr1[] = { 1, -4, -2, 5, 3 };
        printArr(separateNegativeAndPositive(arr1));
        int arr2[] = { -1, -2, 3, 4, 5 };
        printArr(separateNegativeAndPositive(arr2));
        int arr3[] = { 1, 2, -3, 4, -5, 6 };
        printArr(separateNegativeAndPositive(arr3));
    }
}
