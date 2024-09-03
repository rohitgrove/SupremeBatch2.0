import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Info {
    int val, vecIn, index;

    Info(int x, int y, int z) {
        val = x;
        vecIn = y;
        index = z;
    }
}

class Comp implements Comparator<Info> {
    public int compare(Info a, Info b) {
        return a.val - b.val;
    }
}

public class SmallestRangeInKList {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = new int[2];
        int maxx = Integer.MIN_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comp());

        // Initialize the priority queue with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> vi = nums.get(i); // ith list
            pq.offer(new Info(vi.get(0), i, 0));
            maxx = Math.max(maxx, vi.get(0));
        }

        ans[0] = pq.peek().val; // min
        ans[1] = maxx; // max

        // Process the elements in the priority queue
        while (!pq.isEmpty()) {
            Info top = pq.poll();

            if (maxx - top.val < ans[1] - ans[0]) {
                ans[0] = top.val;
                ans[1] = maxx;
            }

            if (top.index + 1 < nums.get(top.vecIn).size()) {
                pq.offer(new Info(nums.get(top.vecIn).get(top.index + 1), top.vecIn, top.index + 1));
                maxx = Math.max(maxx, nums.get(top.vecIn).get(top.index + 1));
            } else {
                break;
            }
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> nums1 = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        List<Integer> row3 = new ArrayList<>();
        row1.add(4);
        row1.add(10);
        row1.add(15);
        row1.add(24);
        row1.add(26);

        row2.add(0);
        row2.add(9);
        row2.add(12);
        row2.add(20);

        row3.add(5);
        row3.add(18);
        row3.add(22);
        row3.add(30);

        nums1.add(row1);
        nums1.add(row2);
        nums1.add(row3);
        printArr(smallestRange(nums1));

        List<List<Integer>> nums2 = new ArrayList<>();
        nums2.add(new ArrayList<>());
        nums2.add(new ArrayList<>());
        nums2.add(new ArrayList<>());
        nums2.get(0).add(1);
        nums2.get(0).add(2);
        nums2.get(0).add(3);

        nums2.get(1).add(1);
        nums2.get(1).add(2);
        nums2.get(1).add(3);

        nums2.get(2).add(1);
        nums2.get(2).add(2);
        nums2.get(2).add(3);

        printArr(smallestRange(nums2));
    }
}
