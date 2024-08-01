import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class PrintFirstNegativeElements {
    public static ArrayList<Integer> firstNegative(int arr[], int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // process first k elements - first window
        for (int index = 0; index < k; index++) {
            int elemnent = arr[index];
            if (elemnent < 0) {
                dq.add(index);
            }
        }

        // process remaining window -> Remocal an Addition
        for (int index = k; index < arr.length; index++) {
            // aage badhne se phele purani window ka answer nikalo
            if (dq.isEmpty()) {
                ans.add(0);
            } else {
                ans.add(arr[dq.peekFirst()]);
            }
            // Removal - jo bhi index out of range h, usko queue se remove kardo
            if (index - dq.peek() >= k) {
                dq.pollFirst();
            }

            // addition
            if (arr[index] < 0) {
                dq.add(index);
            }
        }

        // last window ka asnwer print kar do
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
