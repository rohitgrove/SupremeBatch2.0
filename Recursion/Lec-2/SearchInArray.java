public class SearchInArray {
    public static boolean search(int arr[], int size, int idx, int target) {
        // base case
        if (idx >= size) {
            return false;
        }

        if (arr[idx] == target) {
            return true;
        }

        // recursive call
        return search(arr, size, idx + 1, target);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        boolean ans = search(arr, arr.length, 0, 50);
        if (ans) {
            System.out.println("element is present");
        } else {
            System.out.println("element is not present");
        }
    }
}
