public class FindElement {
    public static int solve(int arr[], int index, int target) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return solve(arr, index + 1, target);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int target = 40;
        System.out.println(solve(arr, 0, target));
    }
}
