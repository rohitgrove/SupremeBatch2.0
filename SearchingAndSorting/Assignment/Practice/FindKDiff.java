import java.util.ArrayList;
import java.util.List;
public class FindKDiff {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        return bs_method(arr, x, k);
    }

    public static List<Integer> twoptr(int nums[], int k, int x) {
        int l = 0;
        int h = nums.length - 1;
        while (h - l >= k) {
            if (x - nums[l] > nums[h] - x) {
                l++;
            } else {
                h--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= h - 1; i++) {
            ans.add(nums[i]);
        }

        return ans;
    }

    public static List<Integer> bs_method(int nums[], int x, int k) {
        int h = lowerBound(nums, x);
        int l = h - 1;
        while (k > 0) {
            if (l <  0) {
                h++;
            } else if (h >= nums.length) {
                l--;
            } else if ((x - nums[l]) > (nums[h] - x)) {
                h++;
            } else {
                l--;
            }
            k--;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = l + 1; i <= h - 1; i++) {
            ans.add(nums[i]);
        }

        return ans;
    }

    public static int lowerBound(int nums[], int x) {
        int s = 0;
        int e = nums.length - 1;
        int ans = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] >= x) {
                ans = mid;
                e = mid - 1;
            } else if (nums[mid] < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
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
