public class MissingAndRepeatingArr {
    public static void missingAndRepeating1(int[] arr, int n) { // Tc: O(n) Sc: O(1)
        // visited
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index - 1] > 0) {
                arr[index - 1] *= -1;
            }
        }

        // printArr(arr);

        // all positive indexes are missing
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.print(i + 1 + " ");
            }
        }
    }

    public static void missingAndRepeating2(int arr[], int n) {
        int i = 0;
        while (i < n) {
            int index = arr[i] - 1;
            if (arr[i] != arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            } else {
                ++i;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1) {
                System.out.print(arr[j] + " ");
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
        int arr[] = { 1, 3, 5, 3, 4 };
        // int arr[] = { 1, 3, 3, 3, 3 };
        missingAndRepeating1(arr, arr.length);
    }
}
