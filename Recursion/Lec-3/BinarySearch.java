public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        int target = 50;
        System.out.println(bs(arr, 0, arr.length - 1, target));
    }

    public static int bs(int[] arr, int s, int e, int target) {
        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return bs(arr, mid + 1, e, target);
        } else {
            return bs(arr, s, mid - 1, target);
        }
    }
}
