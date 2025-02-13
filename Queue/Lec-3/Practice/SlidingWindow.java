import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int ans[] = new int[n - k + 1];
        int ansIndex = 0;

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        for (int i = k; i < n; i++) {
            ans[ansIndex++] = nums[dq.peekFirst()];

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offer(i);
        }

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
