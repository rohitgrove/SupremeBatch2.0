import java.util.Deque;
import java.util.LinkedList;

public class NegativeNumberInWindowk {
    public static void printFirstNeagative(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();

        for (int index = 0; index < k; index++) {
            int element = arr[index];
            if (element < 0) {
                dq.offer(index);
            }
        }

        for (int index = k; index < arr.length; index++) {
            if (dq.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(arr[dq.peek()] + " ");
            }

            if (index - k >= dq.peek()) {
                dq.poll();
            }

            if (arr[index] < 0) {
                dq.offer(index);
            }
        }

        if (dq.isEmpty()) {
            System.out.print("0");
        } else {
            System.out.print(arr[dq.peek()]);
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
