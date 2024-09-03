import java.util.*;

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

public class MargeKSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] v, int K) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comp());

        // Push the first element of each array into the priority queue
        for (int i = 0; i < K; i++) {
            pq.offer(new Info(v[i][0], i, 0));
        }

        // Merge arrays
        while (!pq.isEmpty()) {
            Info front = pq.poll(); // Gives min element
            ans.add(front.val);

            // If there are more elements in the same array, push the next element into the
            // queue
            if (front.index + 1 < v[front.vecIn].length) {
                pq.offer(new Info(v[front.vecIn][front.index + 1], front.vecIn, front.index + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 3;
        System.out.println(mergeKArrays(arr, k));
    }
}
