import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinMaxElementOfSubarrayOfSizeK {
    public static int sumOfKsubArray(int[] nums, int k) {
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();

        // first window ko process karo
        for (int i = 0; i < k; i++) {
            // jitne bhi queue k andar chotte elements h remove kardo
            while (!dq1.isEmpty() && nums[i] >= nums[dq1.peekLast()]) {
                dq1.pollLast();
            }
            // jitne bhi queue k andar bade elements h remove kardo
            while (!dq2.isEmpty() && nums[i] <= nums[dq2.peekLast()]) {
                dq2.pollLast();
            }
            // now insert karo
            dq1.offerLast(i);
            dq2.offerLast(i);
        }

        int addition = nums[dq1.peek()] + nums[dq2.peek()];

        // remaing window ka process karo
        for (int i = k; i < nums.length; i++) {
            // removal
            // out of range elements
            while (!dq1.isEmpty() && dq1.peekFirst() <= i - k) {
                dq1.pollFirst();
            }
            while (!dq2.isEmpty() && dq2.peekFirst() <= i - k) {
                dq2.pollFirst();
            }

            // chote elements ko remove kar do
            while (!dq1.isEmpty() && nums[i] >= nums[dq1.peekLast()]) {
                dq1.pollLast();
            }
            while (!dq2.isEmpty() && nums[i] <= nums[dq2.peekLast()]) {
                dq2.pollLast();
            }
            dq1.addLast(i);
            dq2.addLast(i);

            addition += nums[dq1.peek()] + nums[dq2.peek()];
        }

        return addition;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2 }, K = 4;
        System.out.println(sumOfKsubArray(arr, K));
    }
}