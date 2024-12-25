public class FindMaximum {
    public static int findMax(int arr[], int idx, int size) {
        if (idx >= size) {
            return Integer.MIN_VALUE;
        }

        int num = findMax(arr, idx + 1, size);

        return Math.max(num, arr[idx]);
    }

    public static void main(String[] args) {
        int arr[] = { 20, 30, 10, 5, 11 };
        System.out.println("Minimum number in array: " + findMax(arr, 0, arr.length));
    }
}
