public class MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0, mx = 0;

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, arr[i]);

            if (mx == i) {
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        int arr1[] = { 4, 3, 2, 1, 0 };
        System.out.println(maxChunksToSorted(arr1));
        int arr2[] = { 1, 0, 2, 3, 4 };
        System.out.println(maxChunksToSorted(arr2));
        int arr3[] = { 1, 0, 3, 2, 4, 6, 5 };
        System.out.println(maxChunksToSorted(arr3));
    }
}
