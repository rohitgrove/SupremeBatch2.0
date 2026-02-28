import java.util.Arrays;
import java.util.Comparator;

class Compare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String str1 = o1 + o2;
        String str2 = o2 + o1;
        return str2.compareTo(str1);
    }
}
public class LargesTNumber {
    public static  String largestNumber(int[] nums) {
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
        int nums1[] = {10, 2};
        System.out.println(largestNumber(nums1));
        int nums2[] = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums2));
    }
}
