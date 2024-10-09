import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        // process first k elements
        for (int i = 0; i < k; i++) {
            // jo bhi number chote hai current elementse unhe remove kar do
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
        }
        // storing answer for first window
        ans.add(nums[dq.peek()]);

        // process first remaining elements
        for (int i = k; i < nums.length; i++) {
            // removal
            if (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.removeFirst();
            }
            // addition
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
            // ans store
            ans.add(nums[dq.peek()]);
        }

        int res[] = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
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