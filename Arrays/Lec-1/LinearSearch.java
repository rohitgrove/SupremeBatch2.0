public class LinearSearch {
    // present -> true;
    // absent -> false;

    public static boolean linearSearch(int arr[], int size, int target) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                // found
                return true;
            }
        }
        // not found
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        int size = arr.length;
        int target = 11;

        boolean ans = linearSearch(arr, size, target);

        if (ans) {
            System.out.println("Target found");
        } else {
            System.out.println("Target Not found");
        }
    }

}
