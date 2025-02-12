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
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            // now insert karo
            dq.addLast(i);
        }

        // remaing window ka process karo
        for (int i = k; i < nums.length; i++) {
            // ans store
            ans[ansIndex++] = nums[dq.getFirst()];

            // removal
            // out of range elements
            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            // chote elements ko remove kar do
            while (!dq.isEmpty() && nums[i] >= nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        // last window ko answer process karlo
        ans[ansIndex] = nums[dq.getFirst()];

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
