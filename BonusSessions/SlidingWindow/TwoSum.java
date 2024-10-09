import java.util.Arrays;

class Pair {
    public int element;
    public int index;

    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Pair temp[] = new Pair[nums.length];
        for (int index = 0; index < temp.length; index++) {
            int value = nums[index];
            temp[index] = new Pair(value, index);
        }
        // sort basis on value
        Arrays.sort(temp, (a, b) -> a.element - b.element);
        // int logic
        int s = 0;
        int e = nums.length - 1;

        int ans[] = { -1, -1 };
        while (s < e) {
            int sum = temp[s].element + temp[e].element;
            if (sum == target) {
                ans[0] = temp[s].index;
                ans[1] = temp[e].index;
                return ans;
            } else if (sum > target) {
                e--;
            } else {
                s++;
            }
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        System.out.println(nums[0] + ", " + nums[1]);
    }

    public static void main(String[] args) {
        int nums1[] = { 2, 7, 11, 15 }, target1 = 9;
        printArr(twoSum(nums1, target1));
        int nums2[] = { 3, 2, 4 }, target2 = 6;
        printArr(twoSum(nums2, target2));
        int nums3[] = { 3, 3 }, target3 = 6;
        printArr(twoSum(nums3, target3));
    }
}
