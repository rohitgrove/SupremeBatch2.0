import java.util.PriorityQueue;
import java.util.Collections;

public class FindKthElement {
    public static int kthSmalletElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            int element = arr[i];
            pq.add(element);
        }

        for (int i = k; i < arr.length; i++) {
            int element = arr[i];
            if (element < pq.peek()) {
                pq.poll();
                pq.add(element);
            }
        }

        int ans = pq.peek();
        return ans;
    }

    public static int kthGreatestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            int element = arr[i];
            pq.add(element);
        }

        for (int i = k; i < arr.length; i++) {
            int element = arr[i];
            if (element > pq.peek()) {
                pq.poll();
                pq.add(element);
            }
        }

        int ans = pq.peek();
        return ans;
    }
    public static void main(String[] args) {
        int arr1[] = { 3, 7, 4, 5, 8, 6, 9 };
        int k = 4;

        System.out.println(kthSmalletElement(arr1, k));
        System.out.println(kthGreatestElement(arr1, k));
        int[] arr2 = { 20, 30, 60, 50, 10, 55, 57, 40 };

        System.out.println(kthSmalletElement(arr2, k));
        System.out.println(kthGreatestElement(arr2, k));
    }
}