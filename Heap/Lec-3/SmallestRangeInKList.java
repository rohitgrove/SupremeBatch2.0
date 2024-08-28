import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Info {
    public int data;
    public int rowIndex;
    public int colIndex;

    public Info(int data, int rowIndex, int colIndex) {
        this.data = data;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }
}

class Coustom implements Comparator<Info> {
    @Override
    public int compare(Info o1, Info o2) {
        return Integer.compare(o1.data, o2.data);
    }
}

public class SmallestRangeInKList {
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Coustom());
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        // process first k elements ko
        for (int i = 0; i < nums.size(); i++) {
            int element = nums.get(i).get(0);
            int row = i;
            int col = 0;

            Info temp = new Info(element, row, col);
            pq.add(temp);
            maxi = Math.max(maxi, element);
            mini = Math.min(mini, element);
        }

        int ansStart = mini;
        int ansEnd = maxi;

        while (!pq.isEmpty()) {
            Info topNode = pq.poll();
            
            int topCol = topNode.colIndex;
            int topRow = topNode.rowIndex;
            mini = topNode.data;
            // maxi ki value phele se padhi hui hai
            // compare kar lete hai for smaller range
            if ((maxi - mini) < (ansEnd - ansStart)) {
                // update ans;
                ansStart = mini;
                ansEnd = maxi;
            }

            // insertion wala stop
            if (topCol + 1 < nums.get(topRow).size()) {
                int newElement = nums.get(topRow).get(topCol + 1);
                maxi = Math.max(maxi, newElement);
                Info newInfo = new Info(newElement, topRow, topCol + 1);
                pq.add(newInfo);
            } else {
                // agge koi element nhi hai push karne ko
                break;
            }
        }

        int ans[] = {ansStart, ansEnd};
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
