public class BinarySearch {
    public static int BS(int arr[], int tar, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == tar) {
            return mid;
        } else if (tar > arr[mid]) {
            return BS(arr, tar, mid + 1, end);
        } else {
            return BS(arr, tar, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int target = 80;
        System.out.println(BS(arr, target, 0, arr.length - 1));
    }
}
