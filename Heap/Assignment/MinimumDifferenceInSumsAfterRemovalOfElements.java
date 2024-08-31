import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDifferenceInSumsAfterRemovalOfElements { // tc: O(nlogn) sc: O(n)
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        
        long[] prefix = new long[nums.length];
        long[] suffix = new long[nums.length];
        Arrays.fill(prefix, -1);
        Arrays.fill(suffix, -1);
        // prefix[i] = sum of first n elements from left side. 
        // sufix[i] = sum of first n elements from right side. 
        
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max heap for prefix
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxHeap.add(nums[i]);

            if (maxHeap.size() > n) {
                sum -= maxHeap.poll();
            } 

            if (maxHeap.size() == n) {
                prefix[i] = sum;
            }
        }    

        sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap for suffix

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            minHeap.add(nums[i]);

            if (minHeap.size() > n) {
                sum -= minHeap.poll();
            } 

            if (minHeap.size() == n) {
                suffix[i] = sum;
            }
        }    

        long ans = Long.MAX_VALUE;
        
        for (int i = n - 1; i < 2 * n; i++) {
            if (suffix[i + 1] != -1) { // ensure suffix[i + 1] is valid
                ans = Math.min(ans, prefix[i] - suffix[i + 1]);
            }
        }

        return ans;
    }

    public static void printArr(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = {3, 1, 2};
        System.out.println(minimumDifference(nums1));

        int nums2[] = {7, 9, 5, 8, 1, 3};
        System.out.println(minimumDifference(nums2));
    }
}
