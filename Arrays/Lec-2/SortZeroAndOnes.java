public class SortZeroAndOnes {
    public static void sortZeroOne1(int[] arr, int n) {
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

    public static void sortZeroOne2(int[] arr, int size) {
        int s = 0;
        int e = size - 1;

        while (s < e) {
            // when arr[s]==0 then increase only s++
            while (s < e && arr[s] == 0) {
                s++;
            }

            // when arr[e]==1 then decrease only se--
            while (s < e && arr[e] == 1) {
                e--;
            }

            // when arr[s] == 1 and arr[e] == 0 then
            // increase and decrease respectively s++, e-- and swap
            if (s < e && arr[s] == 1 && arr[e] == 0) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
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
        int[] arr = { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
        int n = 14;
        sortZeroOne2(arr, n);
        printArr(arr);
    }
}
