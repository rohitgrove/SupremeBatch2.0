public class NextPetmutaion {
    public static void nextPermutation(int[] arr) {
        int pivot = -1;
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot >= 0) {
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(arr, i, pivot);
                    break;
                }
            }
        }
        reverse(arr, pivot + 1, arr.length - 1);
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3 };
        nextPermutation(nums1);
        printArr(nums1);
        int nums2[] = { 3, 2, 1 };
        nextPermutation(nums2);
        printArr(nums2);
        int nums3[] = { 1, 1, 5 };
        nextPermutation(nums3);
        printArr(nums3);
    }
}
