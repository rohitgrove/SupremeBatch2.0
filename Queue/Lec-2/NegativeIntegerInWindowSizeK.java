import java.util.Deque;
import java.util.LinkedList;

public class NegativeIntegerInWindowSizeK {
    public static void printFirstNeagative(int arr[], int k) {
        Deque<Integer> dq = new LinkedList<>();
        // process first k elements - first window
        for (int index = 0; index < k; index++) {
            int element = arr[index];
            if (element < 0) {
                dq.offer(index);
            }
        }

        // process remaing windows -> Removal And Addition
        for (int index = k; index < arr.length; index++) {
            // aage badhne se phele purane window ka answer nikal lo
            if (dq.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(arr[dq.peek()] + " ");
            }
            // removal - jo bhi index out of range h, usko queue me se remove kardo
            if (index - dq.peek() >= k) {
                dq.poll();
            }

            // Addition
            if (arr[index] < 0) {
                dq.offer(index);
            }
        }

        // last window ka answer print karado
        if (dq.isEmpty()) {
            System.out.print("0 ");
        } else {
            System.out.print(arr[dq.peek()] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { -2, 0, 4, -5, 8 };
        printFirstNeagative(arr1, 3);
        int arr2[] = { -2, -5, 4, -1, -2, 0, 5 };
        printFirstNeagative(arr2, 3);
    }
}
