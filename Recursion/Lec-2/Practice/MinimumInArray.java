public class MinimumInArray {
    public static int mini(int arr[], int start, int end) {
        if (start == end) {
            return Integer.MAX_VALUE;
        }

        int mini = Math.min(arr[start], mini(arr, start + 1, end));
        return mini;
    }

    public static void main(String[] args) {
        int arr[] = { 20, 30, 10, 5, 11 };
        System.out.println(mini(arr, 0, arr.length - 1));
    }
}
