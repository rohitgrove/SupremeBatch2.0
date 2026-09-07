public class FindMissingElement {
    public static int findMissingElement(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            int diff = arr[mid] - mid;
            if (diff == 1) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }

        if (ans + 1 == 0) {
            ans = arr.length + 1;
        }

        return ans+1;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findMissingElement(arr1));
        int arr2[] = { 1, 2, 3, 4, 5, 6, 8, 9 };
        System.out.println(findMissingElement(arr2));
    }
}
