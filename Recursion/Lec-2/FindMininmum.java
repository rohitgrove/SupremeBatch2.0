public class FindMininmum {
    public static int findMin(int arr[], int idx, int size) {
        if (idx >= size) {
            return Integer.MAX_VALUE;
        }

        int num = findMin(arr, idx + 1, size);

        return Math.min(num, arr[idx]);
    }

    public static void main(String[] args) {
        int arr[] = { 20, 30, 10, 5, 11 };
        System.out.println("Minimum number in array: " + findMin(arr, 0, arr.length));
    }
}
