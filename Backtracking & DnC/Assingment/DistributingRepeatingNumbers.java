import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class DistributingRepeatingNumbers {
    public static boolean canDistributeHelper(int counts[], int[] nums, Integer[] quantity, int ithCoustmer) {
        // base case
        if (ithCoustmer == quantity.length) {
            return true;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= quantity[ithCoustmer]) {
                counts[i] -= quantity[ithCoustmer];
                if (canDistributeHelper(counts, nums, quantity, ithCoustmer + 1)) {
                    return true;
                }
                counts[i] += quantity[ithCoustmer];
            }
        }

        return false;
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                countMap.put(num, count + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int[] counts = new int[countMap.size()];
        int index = 0;
        for (int val : countMap.values()) {
            counts[index++] = val;
        }

        Integer quan[] = new Integer[quantity.length];
        for (int i = 0; i < quan.length; i++) {
            quan[i] = quantity[i];
        }
        Arrays.sort(quan, new Compare());
        return canDistributeHelper(counts, nums, quan, 0);
    }

    static class Compare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // decreasing order sorting
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
