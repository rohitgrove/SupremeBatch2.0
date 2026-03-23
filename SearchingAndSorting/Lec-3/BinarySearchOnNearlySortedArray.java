public class BinarySearchOnNearlySortedArray {
    public static int binarySearchOnNearlySorted(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (mid - 1 >= 0 && target == arr[mid - 1]) {
                return mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            } else if (mid < arr.length && target == arr[mid + 1]) {
                return mid + 1;
            } else if (target > arr[mid]) {
                s = mid + 2;
            } else {
                e = mid - 2;
            }

            mid = s + (e - s) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 20, 10, 30, 50, 40, 70, 60 };
        int target = 20;
        int elementIndex = binarySearchOnNearlySorted(arr, target);

        if (elementIndex == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at Index: " + elementIndex);
        }
    }
}
