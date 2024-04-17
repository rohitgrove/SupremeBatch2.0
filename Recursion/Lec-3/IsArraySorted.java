public class IsArraySorted {
    public static boolean isSorted(int arr[], int index) {
        if (index >= arr.length) {
            return true;
        }

        if (arr[index] > arr[index - 1]) {
            // agge check karna padega ab
            // ab recursion sambhalega
            return isSorted(arr, index + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        if (isSorted(arr, 1)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}