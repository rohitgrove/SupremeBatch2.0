public class SortZeroAndOnes {
    public static void sortZeroOne(int[] arr, int n) {
        int zeroCount = 0;
        int oneCount = 0;

        // Count 0s and 1s
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            } else if (arr[i] == 1) {
                oneCount++;
            }
        }

        // Step B: place all zeroes first
        // int i;
        // for(i =0; i<zeroCount; i++) {
        // arr[i] = 0;
        // }
        // Step B: place all ones first
        // for(int j = i; j<n ;j++) {
        // arr[j] = 1;
        // }

        // Place 0s and 1s in their respective positions
        int index = 0;
        while (zeroCount-- > 0) {
            arr[index++] = 0;
        }
        while (oneCount-- > 0) {
            arr[index++] = 1;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        int n = 14;
        sortZeroOne(arr, n);
        printArr(arr);
    }
}
