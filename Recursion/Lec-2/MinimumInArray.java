public class MinimumInArray {
    public static int findMin(int arr[], int index) {
        if (index == arr.length) {
            return Integer.MAX_VALUE;
        }

        return Math.min(arr[index], findMin(arr, index + 1));
    }

    public static void main(String[] args) {
        int arr[] = { 10, 30, 10, 5, 11 };
        System.out.println(findMin(arr, 0));
    }
}
