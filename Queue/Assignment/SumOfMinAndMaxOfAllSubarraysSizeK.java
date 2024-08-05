import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinAndMaxOfAllSubarraysSizeK {
    public static int sumOfMinimumAndMaximumSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq1 = new LinkedList<>(); // For maximum elements
        Deque<Integer> dq2= new LinkedList<>(); // For minimum elements
        int ans = 0;

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            int ele = nums[i];
            // Remove smaller elements for dq1
            while (!dq1.isEmpty() && ele >= nums[dq1.peekLast()]) {
                dq1.pollLast();
            }

            // Remove larger elements for dq2
            while (!dq2.isEmpty() && ele <= nums[dq2.peekLast()]) {
                dq2.pollLast();
            }

            dq1.addLast(i);
            dq2.addLast(i);
        }

        // Process the remaining windows
        for (int i = k; i < n; i++) {
            // Add the minimum and maximum of the previous window to the sum
            ans += nums[dq1.peekFirst()] + nums[dq2.peekFirst()];

            // Remove elements not within the window
            if (!dq1.isEmpty() && dq1.peekFirst() <= i - k) {
                dq1.pollFirst();
            }

            if (!dq2.isEmpty() && dq2.peekFirst() <= i - k) {
                dq2.pollFirst();
            }

            int ele = nums[i];
            // Remove smaller elements for dq1
            while (!dq1.isEmpty() && ele >= nums[dq1.peekLast()]) {
                dq1.pollLast();
            }

            // Remove larger elements for dq2
            while (!dq2.isEmpty() && ele <= nums[dq2.peekLast()]) {
                dq2.pollLast();
            }

            dq1.addLast(i);
            dq2.addLast(i);
        }

        // Handle the last window
        ans += nums[dq1.peekFirst()] + nums[dq2.peekFirst()];

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2 }, K = 4;
        System.out.println(sumOfMinimumAndMaximumSlidingWindow(arr, K)); // Output should be 18
    }
}
