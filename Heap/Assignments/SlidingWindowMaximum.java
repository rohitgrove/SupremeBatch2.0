import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // {val, index}

        // consider first window.
        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        // store max of first window
        ans[0] = pq.peek()[0];
        int ansIdx = 1;

        // consider rest of the windows
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[] { nums[i], i });

            // remove if maxs are from previous windows.
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            ans[ansIdx++] = pq.peek()[0];
        }

        return ans;
    }

    public static void printArr(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k = 3;
        printArr(maxSlidingWindow(nums, k));
    }
}
