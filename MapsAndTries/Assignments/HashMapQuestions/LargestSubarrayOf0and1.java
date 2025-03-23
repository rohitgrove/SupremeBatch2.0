import java.util.HashMap;

public class LargestSubarrayOf0and1 {
    public static int maxLen(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int csum = 0;
        int maxLen = 0; // max len if sub Array with 0 sum

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] == 0 ? -1 : 1;
            csum += val;
            if (csum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            } else if (!map.containsKey(csum)) {
                map.put(csum, i);
            } else {
                // map has csum already.
                maxLen = Math.max(maxLen, i - map.get(csum));
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 0, 1, 1, 1, 0, 0 };
        System.out.println(maxLen(nums1));
        int nums2[] = { 0, 0, 1, 1, 0 };
        System.out.println(maxLen(nums2));
        int nums3[] = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.out.println(maxLen(nums3));
    }
}