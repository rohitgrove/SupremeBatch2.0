public class KthNodeFromEndDelete {
    public static int len(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }
    public static Node removeNthFromEnd(Node head, int n) {
        // Step 1: Calculate the length of the linked list
        int length = len(head);
        Node current = head;
        
        // Step 2: Find the node just before the one we need to remove
        int positionToReach = length - n - 1;
        
        // Special case: If we need to remove the head
        if (positionToReach == -1) {
            return head.next;
        }
        
        // Traverse to the node just before the one we want to remove
        while (positionToReach > 0) {
            current = current.next;
            positionToReach--;
        }
        
        // Step 3: Adjust the pointers to skip the node to be removed
        current.next = current.next.next;
        
        return head;
    }
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(1);
        ll1.insertAtTail(2);
        ll1.insertAtTail(3);
        ll1.insertAtTail(4);
        ll1.insertAtTail(5);
        ll1.printLL();
        ll1.printLL(removeNthFromEnd(ll1.head, 2));
    }    
}
