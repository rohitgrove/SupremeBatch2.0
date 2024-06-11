public class ReverseKGroup {
    public static int getLength(Node head) {
        Node temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    public static Node reverseKGroup(Node head, int k) {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            return head;
        }
    
        //1 case main solve karunga
        Node prev = null;
        Node curr = head;
        Node nextNode = curr.next;
        int pos = 0;
    
        int len = getLength(head);
        if(len < k) {
            return head;
        }
    
        while(pos < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            pos++;
        }
    
        Node recursionKaAns = null;
        if(nextNode != null) {
            recursionKaAns = reverseKGroup(nextNode, k);
            head.next = recursionKaAns;
        }
    
        return prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(5);
        ll.insertAtHead(4);
        ll.insertAtHead(3);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        ll.printLL(reverseKGroup(ll.head, 3));
    }
}