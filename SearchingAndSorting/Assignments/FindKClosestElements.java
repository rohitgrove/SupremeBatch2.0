import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> bruteForce(int arr[], int k, int x) { // tc: O(nlogn) sc: O(n)
        int sorted[][] = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int diff = Math.abs(x - element);
            sorted[i][0] = element;
            sorted[i][1] = diff;
        }

        Arrays.sort(sorted, (a, b) -> a[1] - b[1]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(sorted[i][0]);
        }

        Collections.sort(res);

        return res;
    }

    public static List<Integer> twoPtrMethod(int arr[], int k, int x) { // tc: O(n) sc: O(k)
        int l = 0, h = arr.length - 1;
        while (h - l >= k) {
            if (x - arr[l] > arr[h] - x) {
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

    public static List<Integer> bsMethod(int arr[], int k, int x) { // tc: O(log n + k) sc: O(k)
        // lower bound.
        int h = lowerBound(arr, x);
        int l = h - 1;
        while (k-- > 0) {
            if (l < 0) {
                h++;
            } else if (h >= arr.length) {
                l--;
            } else if (x - arr[l] > arr[h] - x) {
                h++;
            } else {
                l--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = l + 1; i < h; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    public static int lowerBound(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                end = mid - 1;
            } else if (x > arr[mid]) {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        return bsMethod(arr, k, x);
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 }, k1 = 4, x1 = 3;
        System.out.println(findClosestElements(arr1, k1, x1));
        int arr2[] = { 1, 1, 2, 3, 4, 5 }, k2 = 4, x2 = -1;
        System.out.println(findClosestElements(arr2, k2, x2));
        int arr3[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 }, k3 = 4, x3 = 35;
        System.out.println(findClosestElements(arr3, k3, x3));
    }
}
