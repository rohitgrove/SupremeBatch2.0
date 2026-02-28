import java.util.Arrays;

public class MajorityElement {
    public static int bruteForce(int nums[]) {
        for (int val : nums) {
            int freq = 0;

            for (int ele : nums) {
                if (ele == val) {
                    freq++;
                }
            }

            if (freq > nums.length / 2) {
                return val;
            }
        }

        return -1;
    }
   
    public static int betterApproach1(int nums[]) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    public static int betterApproach2(int nums[]) {
        Arrays.sort(nums);
        // freq count
        int freq = 1, ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                freq++;
            } else {
                freq = 1;
                ans = nums[i];
            }

            if (freq > nums.length / 2) {
                return ans;
            }
        }

        return ans;
    }

    public static int optimizedApproachMoorsAlgo(int nums[]) {
        int freq = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }

        return ans;
    }

    public static int majorityElement(int[] nums) {
        return optimizedApproachMoorsAlgo(nums);
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));
        int nums2[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums2));
    }
}
