import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class MinimumDiffrenceSumBetween {
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long prefix[] = new long[nums.length];
        long sufix[] = new long[nums.length];
        Arrays.fill(prefix, -1);
        Arrays.fill(sufix, -1);

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            maxheap.add(nums[i]);

            if (maxheap.size() > n) {
                ans -= maxheap.poll();
            }

            if (maxheap.size() == n) {
                prefix[i] = ans;
            }
        }

        ans = 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans += nums[i];
            minheap.add(nums[i]);

            if (minheap.size() > n) {
                ans -= minheap.poll();
            }

            if (minheap.size() == n) {
                sufix[i] = ans;
            }
        }

        
        ans = Integer.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (sufix[i + 1] != -1) {
                ans = Math.min(ans, prefix[i] - sufix[i + 1]);
            }
        }

        return ans;
    }

    public static void printArr(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 3, 1, 2 };
        System.out.println(minimumDifference(nums1));

        int nums2[] = { 7, 9, 5, 8, 1, 3 };
        System.out.println(minimumDifference(nums2));
    }
}
