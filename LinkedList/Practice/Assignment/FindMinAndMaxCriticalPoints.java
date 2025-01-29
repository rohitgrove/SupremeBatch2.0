public class FindMinAndMaxCriticalPoints {
    public static int[] nodesBetweenCriticalPoints(Node head) {
        int ans[] = new int[] { -1, -1 };
        Node prev = head;
        if (prev == null) {
            return ans;
        }
        Node curr = head.next;
        if (curr == null) {
            return ans;
        }
        Node next = head.next.next;
        if (next == null) {
            return ans;
        }

        int firstCP = -1;
        int lastCP = -1;
        int i = 1;
        int minDist = Integer.MAX_VALUE;

        while (next != null) {
            boolean cp = ((curr.data > prev.data && curr.data > next.data)
                    || (curr.data < prev.data && curr.data < next.data));

            if (cp && firstCP == -1) {
                firstCP = i;
                lastCP = i;
            } else if (cp) {
                minDist = Math.min(minDist, i - lastCP);
                lastCP = i;
            }
            i++;
            prev = prev.next;
            curr = curr.next;
            next = next.next;
        }

        if (firstCP == lastCP) {
            return ans;
        } else {
            ans[0] = minDist;
            ans[1] = lastCP - firstCP;
            return ans;
        }
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(5);
        ll1.insertAtTail(3);
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(5);
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.printLL();
        int ans1[] = nodesBetweenCriticalPoints(ll1.head);
        System.out.println(ans1[0] + " " + ans1[1]);
        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(1);
        ll2.insertAtTail(3);
        ll2.insertAtTail(2);
        ll2.insertAtTail(2);
        ll2.insertAtTail(3);
        ll2.insertAtTail(2);
        ll2.insertAtTail(2);
        ll2.insertAtTail(2);
        ll2.insertAtTail(7);
        ll2.printLL();
        int ans2[] = nodesBetweenCriticalPoints(ll2.head);
        System.out.println(ans2[0] + " " + ans2[1]);
    }

}
