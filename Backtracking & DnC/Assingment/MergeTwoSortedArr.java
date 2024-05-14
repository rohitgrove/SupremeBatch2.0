public class MergeTwoSortedArr {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void merge(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int total_len = n + m;
        int gap = (total_len / 2) + (total_len % 2);
        while (gap > 0) {
            int i = 0, j = gap;
            while (j < total_len) {
                // comparing elements in first array - if arr2[j] < arr1[i] swap their values
                if (j < n && arr1[i] > arr2[j]) {
                    swap(arr1, arr2, i, j);
                }

                // comparing elements in both arrays
                else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
                    swap(arr1, arr2, i, (j - n));
                } 

                // comparing elements in the second array
                else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
                    swap(arr2, arr2, (i - n), (j - n));
                }

                j++;
                i++;
            }

            gap = gap <= 1 ? 0 : (gap / 2) + (gap % 2);
        }
    }

    public static void swap(int arr1[], int arr2[], int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 8, 9, 12, 13 };
        int arr2[] = { 3, 4, 7, 10 };
        merge(arr1, arr2);
    }
}
