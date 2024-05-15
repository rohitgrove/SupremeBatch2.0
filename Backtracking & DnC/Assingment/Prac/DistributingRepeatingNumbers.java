import java.util.HashMap;
import java.util.Comparator;
import java.util.Arrays;

public class DistributingRepeatingNumbers {
    public static boolean canDistributeHelper(int count[], int[] nums, Integer[] quantity, int ithCustomer) {
        if (ithCustomer == quantity.length) {
            return true;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= quantity[ithCustomer]) {
                count[i] -= quantity[ithCustomer];
                if (canDistributeHelper(count, nums, quantity, ithCustomer + 1)) {
                    return true;
                }
                count[i] += quantity[ithCustomer];
            }
        }

        return false;
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int count = countMap.get(nums[i]);
                countMap.put(nums[i], count + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }

        int count[] = new int[countMap.size()];
        int i = 0;
        for (int val : countMap.values()) {
            count[i++] = val;
        }
        Integer quan[] = new Integer[quantity.length];
        for (int j = 0; j < quan.length; j++) {
            quan[j] = quantity[j];
        }

        Arrays.sort(quan, new Compare());
        return canDistributeHelper(count, nums, quan, 0);
    }

    static class Compare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4 }, quantity1[] = { 2 };
        System.out.println(canDistribute(nums1, quantity1));
        int nums2[] = { 1, 2, 3, 3 }, quantity2[] = { 2 };
        System.out.println(canDistribute(nums2, quantity2));
        int nums3[] = { 1, 1, 2, 2 }, quantity3[] = { 2, 2 };
        System.out.println(canDistribute(nums3, quantity3));
        int nums4[] = { 1, 1, 2, 2, 2, 2, 3, 3 }, quantity4[] = { 2, 2, 3 };
        System.out.println(canDistribute(nums4, quantity4));
        int nums5[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14,
                15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27,
                28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40,
                41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50 },
                quantity5[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };
        System.out.println(canDistribute(nums5, quantity5));
    }
}
