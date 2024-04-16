public class MaximumInArray {
    public static int maxNumber(int arr[], int index) {
        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        return Math.max(arr[index], maxNumber(arr, index + 1));
    }

    public static void main(String[] args) {
        int arr[] = { 10, 30, 10, 5, 11 };
        System.out.println(maxNumber(arr, 0));
    }
}
