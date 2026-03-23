import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Compare implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class DistributeRepeatingIntegers {
    public static boolean canDistributeHelper(int[] nums, int[] quantity, int[] counts, int ithCustomer) {
        if (ithCustomer >= quantity.length) {
            return true;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= quantity[ithCustomer]) {
                counts[i] -= quantity[ithCustomer];
                if (canDistributeHelper(nums, quantity, counts, ithCustomer + 1)) {
                    return true;
                }
                counts[i] += quantity[ithCustomer];
            }
        }

        return false;
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        int counts[] = new int[countMap.size()];
        int idx = 0;
        for (int count : countMap.values()) {
            counts[idx++] = count;
        }
        Integer quan[] = new Integer[quantity.length];
        for (int i = 0; i < quan.length; i++) {
            quan[i] = quantity[i];
        }

        Arrays.sort(quan, new Compare());
        return canDistributeHelper(nums, quantity, counts, 0);
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4 }, quantity1[] = { 2 };
        System.out.println(canDistribute(nums1, quantity1));
        int nums2[] = { 1, 2, 3, 3 };
        System.out.println(canDistribute(nums2, quantity1));
        int nums3[] = { 1, 1, 2, 2 }, quantity2[] = { 2, 2 };
        System.out.println(canDistribute(nums3, quantity2));
        int nums4[] = { 1, 1, 2, 2, 2, 2, 3, 3 }, quantity[] = { 2, 2, 3 };
        System.out.println(canDistribute(nums4, quantity));
    }
}
