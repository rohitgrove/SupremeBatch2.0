public class BinarySearch {
    public static int BS(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return BS(arr, target, mid + 1, end);
        } else {
            return BS(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 80;
        System.out.println(BS(arr, target, 0, arr.length - 1));
    }
}