import java.util.Arrays;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String snums[] = new String[nums.length];
        for (int idx = 0; idx < nums.length; idx++) {
            snums[idx] = Integer.toString(nums[idx]);
        }

        Arrays.sort(snums, new Compare());
        if (snums[0].equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String str : snums) {
            ans.append(str);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 2 };
        System.out.println(largestNumber(nums1));
        int nums2[] = { 3, 30, 34, 5, 9 };
        System.out.println(largestNumber(nums2));
    }
}
