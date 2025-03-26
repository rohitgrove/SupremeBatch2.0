public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int s = 0;
        int e = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (e < nums.length) {
            // sum me include karo value
            sum = sum + nums[e];
            // ho sacta hai, sum == target ho
            // ho sacta hai, sum > target ho
            // ho sacta hai, sum < target ho

            // minimize -> eqaul or greater
            // explore -> lesser
            while (sum >= target) {
                // minimize
                len = Math.min(len, e - s + 1);
                // current element, pointed by start, should be removed from sum
                sum = sum - nums[s];
                s++;
            }
            // loop se bahar matlab, guarantee -> sum < target
            // explore
            e++;
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        }

        return len;
    }

    public static void main(String[] args) {
        int target = 7, nums[] = { 2, 3, 1, 2, 4, 3 };
        System.out.println(minSubArrayLen(target, nums));
    }
}
