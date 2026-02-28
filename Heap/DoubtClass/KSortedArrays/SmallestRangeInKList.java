import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeInKList {
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new Info(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }

        int rangeStart = pq.peek().data, rangeEnd = max;
        while (!pq.isEmpty()) {
            Info top = pq.poll();
            
            if (max - top.data < rangeEnd - rangeStart) {
                rangeStart = top.data;
                rangeEnd = max;
            }

            if (top.data + 1 < nums.get(top.data).size()) {
                pq.offer(new Info(nums.get(top.rowIndex).get(top.colIndex + 1), top.rowIndex, top.colIndex + 1));
                max = Math.max(max, nums.get(top.rowIndex).get(top.colIndex + 1));
            } else {
                break;
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        nums.add(list1);
        nums.add(list2);
        nums.add(list3);

        printArr(smallestRange(nums));
    }
}
