public class PrintIndexesOfTarget {
    public static void printIdx(int arr[], int target, int idx) {
        if (idx >= arr.length) {
            return;
        }

        if (arr[idx] == target) {
            System.out.print(idx + " ");
        }

        printIdx(arr, target, idx + 1);
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 10, 10, 30, 40};
        int target = 10;
        int idx = 0;
        printIdx(arr, target, idx);
    }
}
