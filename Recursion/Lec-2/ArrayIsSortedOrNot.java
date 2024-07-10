public class ArrayIsSortedOrNot {
    public static boolean isSorted(int arr[], int s) {
        if (s == arr.length - 1) {
            return true;
        }

        return arr[s] <= arr[s + 1] && isSorted(arr, s + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 20, 23, 23, 45, 78, 88 };
        if (isSorted(arr, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
