import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int ansIndex = 0;

        // first window ko process karo
        for (int i = 0; i < k; i++) {
            // jitne bhi queue k andar chotte elements h remove kardo
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // now insert karo
            dq.offerLast(i);
        }

        // remaing window ka process karo
        for (int i = k; i < nums.length; i++) {
            // ans store
            ans[ansIndex++] = nums[dq.peekFirst()];

            // removal
            // out of range elements
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // chote elements ko remove kar do
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        // last window ko answer process karlo
        ans[ansIndex] = nums[dq.peekFirst()];

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k1 = 3;
        printArr(maxSlidingWindow(nums1, k1));
        int nums2[] = { 3, 15, 6, 12, 2, 10, 9, 13 }, k2 = 4;
        printArr(maxSlidingWindow(nums2, k2));
    }
}
