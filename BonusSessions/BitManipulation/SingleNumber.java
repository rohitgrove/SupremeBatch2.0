public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i]; 
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 2, 1 };
        System.out.println(singleNumber(nums1));
        int nums2[] = { 4, 1, 2, 1, 2 };
        System.out.println(singleNumber(nums2));
    }
}
