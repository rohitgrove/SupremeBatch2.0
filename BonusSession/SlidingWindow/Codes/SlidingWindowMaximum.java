import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans[] = new int[nums.length - k + 1];
        int idx = 0;

        // process first k elements
        for (int i = 0; i < k; i++) {
            // jo bhi num se, chotte h current element se, unhe remove kardo
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offer(i);
        }

        // storing answer for first window
        ans[idx++] = nums[dq.peek()];

        // process remaing windows
        for (int i = k; i < nums.length; i++) {
            // removal
            // remove the out of range index from queue
            if (!dq.isEmpty() && i - dq.peek() >= k) {
                dq.pollFirst();
            }
            // addition
            // jo bhi num se, chotte h current element se, unhe remove kardo
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offer(i);
            // ans store
            ans[idx++] = nums[dq.peek()];
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
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
        printArr(maxSlidingWindow(nums, k));
    }
}