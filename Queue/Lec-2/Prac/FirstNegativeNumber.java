import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class FirstNegativeNumber {
    public static ArrayList<Integer> firstNegative(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int index = 0; index < k; index++) {
            int element = arr[index];
            if (element < 0) {
                dq.addLast(index);
            }
        }

        for (int index = k; index < arr.length; index++) {
            if (dq.isEmpty()) {
                ans.add(0);
            } else {
                ans.add(arr[dq.getFirst()]);
            }

            if (index - dq.peek() >= k) {
                dq.pollFirst();
            }

            if (arr[index] < 0) {
                dq.add(index);
            }
        }

        if (dq.isEmpty()) {
            ans.add(0);
        } else {
            ans.add(dq.getFirst());
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, -5, 4, -1, -2, 0, 5 };
        System.out.println(firstNegative(arr, 3));
    }
}