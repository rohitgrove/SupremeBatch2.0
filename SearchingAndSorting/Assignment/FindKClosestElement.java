import java.util.List;
import java.util.ArrayList;

public class FindKClosestElement {
    public static List<Integer> twoPtrMethod(int arr[], int k, int x) { // tc: O(n-k)
        int l = 0, h = arr.length - 1;
        while (h - l >= k) {
            if ((x - arr[l]) > (arr[h] - x)) {
                l++;
            } else {
                h--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= h; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        return bs_method(arr, k, x);
    }

    public static int lowerBound(int arr[], int x) {
        int start = 0, end = arr.length - 1;
        int ans = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                end = mid - 1;
            } else if (x > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static List<Integer> bs_method(int arr[], int k, int x) { // tc: O(n)
        int h = lowerBound(arr, x);
        int l = h - 1;
        while (k > 0) {
            if (l < 0) {
                h++;
            } else if (h >= arr.length) {
                l--;
            } else if (x - arr[l] > arr[h] - x) {
                h++;
            } else {
                l--;
            }
            k--;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = l + 1; i <= h - 1; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 }, k1 = 4, x1 = 3;
        System.out.println(findClosestElements(arr1, k1, x1));
        int arr2[] = { 1, 2, 3, 4, 5 }, k2 = 4, x2 = -1;
        System.out.println(findClosestElements(arr2, k2, x2));
        int arr3[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 }, k3 = 4, x3 = 35;
        System.out.println(findClosestElements(arr3, k3, x3));
    }
}
