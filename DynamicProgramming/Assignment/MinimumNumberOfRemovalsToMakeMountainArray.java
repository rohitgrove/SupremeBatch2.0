import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static int solveOptimal(int[] arr, List<Integer> lis) { // tc: O(nLogn)
        if (arr.length == 1) {
            return 0;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        lis.add(1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                // Include
                ans.add(arr[i]);
                lis.add(ans.size());
            } else {
                // Overwrite
                int index = Collections.binarySearch(ans, arr[i]);
                if (index < 0) {
                    index = Math.abs(index) - 1;
                }
                ans.set(index, arr[i]);
                lis.add(index + 1);
            }
        }

        return ans.size();
    }

    public static void revesrse(int nums[]) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static int minimumMountainRemovals(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        List<Integer> lds = new ArrayList<>();

        solveOptimal(nums, lis);
        revesrse(nums);
        solveOptimal(nums, lds);

        int largestMountain = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (lis.get(i) == 1 || lds.get(nums.length - i - 1) == 1) {
                continue;
            }
            largestMountain = Math.max(largestMountain, lis.get(i) + lds.get(nums.length - i - 1) - 1);
        }

        int minRemovals = nums.length - largestMountain;
        return minRemovals;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, 1 };
        System.out.println(minimumMountainRemovals(nums1));
        int nums2[] = { 2, 1, 1, 5, 6, 2, 3, 1 };
        System.out.println(minimumMountainRemovals(nums2));
    }
}