public class ValidBSTFromPreorder {
    public static void build(int[] idx, int min, int max, int[] arr) {
        if (idx[0] >= arr.length) {
            return;
        }

        if (arr[idx[0]] > min && arr[idx[0]] < max) {
            int rootData = arr[idx[0]++];
            build(idx, min, rootData, arr);
            build(idx, rootData, max, arr);
        }
    }

    public static int solve(int[] arr) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        int idx[] = { 0 };

        build(idx, min, max, arr);
        return idx[0] == arr.length ? 1 : 0;
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 7, 10, 10, 9, 5, 2, 8 };
        System.out.println(solve(arr1));
        int arr2[] = { 10, 8, 7, 9, 20, 15, 21 };
        System.out.println(solve(arr2));
    }
}
