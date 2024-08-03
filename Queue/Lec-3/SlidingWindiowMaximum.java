import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindiowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            int ele = nums[i];
            while (!dq.isEmpty() && ele > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.add(i);
        }

        // Process the remaining windows
        for (int i = k; i < n; i++) {
            result.add(nums[dq.peekFirst()]);

            // Remove elements not within the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            int ele = nums[i];
            while (!dq.isEmpty() && ele > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.add(i);
        }

        // Handle the last window
        result.add(nums[dq.peekFirst()]);

        // list to array
        int res[] = new int[result.size()];
        Arrays.setAll(res, result::get);
        return res;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
        printArr(nums);
        int res[] = maxSlidingWindow(nums, k);
        printArr(res);
    }
}
