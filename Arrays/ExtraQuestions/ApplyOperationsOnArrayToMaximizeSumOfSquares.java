import java.util.ArrayList;
import java.util.List;

public class ApplyOperationsOnArrayToMaximizeSumOfSquares {
    public static int maxSum(int[] nums, int k) {
        int m = (int) 1e9 + 7;
        int[] cnt = new int[32];

        for (int i : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if (((i >> bit) & 1) != 0) {
                    cnt[bit]++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < k; i++) {
            int x = 0;

            for (int bit = 0; bit < 32; bit++) {
                if (cnt[bit] > 0) {
                    x += (1 << bit);
                    cnt[bit]--;
                }
            }

            ans = (int) ((ans + (1L * x * x) % m) % m);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(2);
        nums1.add(6);
        nums1.add(5);
        nums1.add(8);
        System.out.println(maxSum(nums1, 2));

        List<Integer> nums2 = new ArrayList<>();
        nums2.add(4);
        nums2.add(5);
        nums2.add(4);
        nums2.add(7);
        System.out.println(maxSum(nums2, 3));
    }
}
