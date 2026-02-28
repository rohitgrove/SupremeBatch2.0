import java.util.ArrayList;
import java.util.List;

public class RearrangeElementsBySign {
    public static int[] rearrangeArray1(int[] nums) {
        // Method 1. Brute Force with Temp Array
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            }
            else {
                pos.add(num);
            }
        }

        int ans[] = new int[nums.length];
        int i = 0;
        int j = 0;
        while (i < pos.size()) {
            ans[j++] = pos.get(i);
            ans[j++] = neg.get(i);
            i++;
        }

        return ans;
    }

    public static int[] rearrangeArray2(int[] nums) {
        int ans[] = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                ans[even] = num;
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
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, -2, -5, 2, -4 };
        printArr(rearrangeArray2(nums));
    }
}
