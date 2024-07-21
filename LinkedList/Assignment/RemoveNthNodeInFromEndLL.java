public class RemoveNthNodeInFromEndLL {
    public static Node removeNthFromEnd(Node head, int n) {
        // Step 1: Calculate the length of the linked list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        // Step 2: Find the node just before the one we need to remove
        int positionToReach = length - n - 1;
        
        // Special case: If we need to remove the head
        if (positionToReach == -1) {
            return head.next;
        }
        
        // Traverse to the node just before the one we want to remove
        current = head;
        for (int i = 0; i < positionToReach; i++) {
            current = current.next;
        }
        
        // Step 3: Adjust the pointers to skip the node to be removed
        current.next = current.next.next;
        
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(1);       
        ll.insertAtTail(2);       
        ll.insertAtTail(3);       
        ll.insertAtTail(4);       
        ll.insertAtTail(5);
        ll.printLL();
        ll.head = removeNthFromEnd(ll.head, 2);
        ll.printLL();
    }
}