import java.util.PriorityQueue;
import java.util.Collections;

public class FindKthElement {
    public static int kthSmalletElement(int[] arr, int k) { // t.c: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // first k element ko process karo
        for (int i = 0; i < k; i++) {
            int element = arr[i];
            pq.add(element);
        }

        // remaing element ko tabhi insert karenge jab vo root chotte honge
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

    public static int kthGreatestElement(int[] arr, int k) { // t.c: O(n)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // first k element ko process karo
        for (int i = 0; i < k; i++) {
            int element = arr[i];
            pq.add(element);
        }

        // remaing element ko tabhi insert karenge jab vo root bade honge
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
