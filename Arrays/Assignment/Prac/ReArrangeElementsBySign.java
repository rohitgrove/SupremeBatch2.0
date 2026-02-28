import java.util.ArrayList;
import java.util.List;

public class ReArrangeElementsBySign {
    public static List<Integer> rearrangeArray1(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num < 0)
                neg.add(num);
            else
                pos.add(num);
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < pos.size()) {
            ans.add(pos.get(i));
            ans.add(neg.get(i));
            i++;
        }

        return ans;
    }
    public static int[] rearrangeArray2(int[] nums) {
        int ans[] = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < ans.length; i++) {
            if (nums[i] > 0) {
                ans[even] = nums[i];
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, -2, -5, 2, -4 };
        System.out.println(rearrangeArray1(nums));
    }
}
