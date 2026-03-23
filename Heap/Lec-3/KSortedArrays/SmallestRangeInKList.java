import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeInKList {
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());
        int maxi = Integer.MIN_VALUE;

        // 1 step: process first k elements
        for (int i = 0; i < nums.size(); i++) {
            int element = nums.get(i).get(0);
            int row = i;
            int col = 0;
            Info temp = new Info(element, row, col);
            pq.offer(temp);
            maxi = Math.max(maxi, element);
        }

        int ansStart = pq.peek().data;
        int ansEnd = maxi;

        while (!pq.isEmpty()) {
            Info topNode = pq.poll();
            int topData = topNode.data;
            int topCol = topNode.colIndex;
            int topRow = topNode.rowIndex;

            int mini = topData;
            // maxi ki value pehle se padi hue hai
            // compare karlete h for smaller range
            if ((maxi - mini) < (ansEnd - ansStart)) {
                // update answer
                ansStart = mini;
                ansEnd = maxi;
            }

            // insertion wala step
            if (topCol + 1 < nums.get(topRow).size()) {
                int newElement = nums.get(topRow).get(topCol + 1);
                maxi = Math.max(maxi, newElement);
                Info newInfo = new Info(newElement, topRow, topCol + 1);
                pq.offer(newInfo);
            } else {
                // aage koi element nhi hai push karne ko
                break;
            }
        }

        return new int[] { ansStart, ansEnd };
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
