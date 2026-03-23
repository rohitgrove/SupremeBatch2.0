public class MoveAllNegativeNumber {
    public static int[] separateNegativeAndPositive(int arr[]) {
        // Dutch National flag algo
        int l = 0, h = arr.length - 1;
        while (l < h) {
            if (arr[l] < 0) {
                l++;
            } else if (arr[h] > 0) {
                h--;
            } else {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
            }
        }

        return arr;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
