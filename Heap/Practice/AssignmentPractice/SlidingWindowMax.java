import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    public int element;
    public int index;

    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}

class Comp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.element - o1.element;
    }

}

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comp());
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }

        res.add(pq.peek().element);

        for (int i = k; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));

            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.poll();
            }

            res.add(pq.peek().element);
        }

        int ans[] = new int[res.size()];
        Arrays.setAll(ans, res::get);
        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 3, -1, -3, 5, 3, 6, 7 }, k1 = 3;
        printArr(maxSlidingWindow(nums1, k1));
        int nums2[] = { 1 }, k2 = 1;
        printArr(maxSlidingWindow(nums2, k2));
    }
}
