import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallestEle(int arr[], int k) { // tc: O(n), sc: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        while (k-- > 1) {
            pq.poll();
        }

        return pq.peek();
    }

    public static int kthSmallestEleOptimizedSC(int arr[], int k) { // tc: O(n), sc: O(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // first k element ko process karo
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }

        // remaing element ko tabhi inasert karenge jab vo root se chotte honge
        for (int i = k; i < arr.length; i++) {
            int element = arr[i];
            if (element < pq.peek()) {
                pq.poll();
                pq.offer(element);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int arr1[] = { 3, 7, 4, 5, 8, 6, 9 };
        System.out.println(kthSmallestEleOptimizedSC(arr1, 3));
        int arr2[] = { 3, 2, 1, 5, 6, 4 };
        System.out.println(kthSmallestEle(arr2, 2));
        int arr3[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(kthSmallestEleOptimizedSC(arr3, 4));
    }
}