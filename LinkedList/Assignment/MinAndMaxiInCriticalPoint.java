import java.util.Arrays;

public class MinAndMaxiInCriticalPoint {
    public static int[] nodesBetweenCriticalPoints(Node head) {
        int ans[] = new int[2];
        Arrays.fill(ans, -1);

        Node prev = head;
        Node curr = head.next;
        Node next = head.next.next;
        if (prev == null || curr == null || next == null) {
            return ans;
        }

        int firstCP = -1;
        int lastCP = -1;
        int minDist = Integer.MAX_VALUE;
        int i = 1;

        while (next != null) {
            boolean isCP = (curr.data > prev.data && curr.data > next.data)
                    || (curr.data < prev.data && curr.data < next.data);

            if (isCP) {
                if (isCP && firstCP == -1) {
                    firstCP = i;
                    lastCP = i;
                } else if (isCP) {
                    minDist = Math.min(minDist, i - lastCP);
                    lastCP = i;
                }
            }

            prev = prev.next;
            curr = curr.next;
            next = next.next;
            i++;
        }

        if (lastCP == firstCP) {
            // Only 1 CP was found
            return ans;
        } else {
            ans[0] = minDist;
            ans[1] = lastCP - firstCP;
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
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(3);
        ll1.insertAtTail(1);
        printArr(nodesBetweenCriticalPoints(ll1.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(5);
        ll2.insertAtTail(3);
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        ll2.insertAtTail(5);
        ll2.insertAtTail(1);
        ll2.insertAtTail(2);
        printArr(nodesBetweenCriticalPoints(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtTail(1);
        ll3.insertAtTail(3);
        ll3.insertAtTail(2);
        ll3.insertAtTail(2);
        ll3.insertAtTail(3);
        ll3.insertAtTail(2);
        ll3.insertAtTail(2);
        ll3.insertAtTail(2);
        ll3.insertAtTail(7);
        printArr(nodesBetweenCriticalPoints(ll3.head));
    }
}
