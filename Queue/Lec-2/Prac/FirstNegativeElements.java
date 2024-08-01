import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstNegativeElements {
    public static ArrayList<Integer> firstNegative(int arr[], int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int index = 0; index < k; index++) {
            int elemnent = arr[index];
            if (elemnent < 0) {
                dq.add(index);
            }
        }

        for (int index = k; index < arr.length; index++) {
            if (dq.isEmpty()) {
                ans.add(0);
            } else {
                ans.add(arr[dq.peekFirst()]);
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
            ans.add(arr[dq.peekFirst()]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, -5, 4, -1, -2, 0, 5 };
        System.out.println(firstNegative(arr1, 3));
        int arr2[] = {-2, 0, 4, -1, -5, 6};
        System.out.println(firstNegative(arr2, 3));
    }
}
