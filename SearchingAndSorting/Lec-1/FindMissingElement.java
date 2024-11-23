public class FindMissingElement {
    public static int findMissingElement(int arr[]) { // tc: O(logn), sc: O(1)
        int s = 0;
        int e = arr.length - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            int diff = arr[mid] - mid;
            if (diff == 1) {
                // right me jao
                s = mid + 1;
            } else {
                // ans store
                ans = mid;
                // left me jao
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }

        if (ans + 1 == 0) {
            return arr.length + 1;
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(findMissingElement(arr));
    }
}
