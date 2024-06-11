public class DetectFindStaringAndRemoveCycle {
    public Node getStartingPoint(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        // yha pohoch chuke ho toh, iska mtlb slow and fast meet kr chuke hai
        slow = head;

        // slow and fast -> 1 step
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        // return starting point
        return slow;
    }

    public void removeLoop(Node head) {
        Node startingPoint = getStartingPoint(head);
        Node temp = startingPoint;
        while(temp.next != startingPoint) { 
            temp = temp.next;
        }

        temp.next = null;
    }
}