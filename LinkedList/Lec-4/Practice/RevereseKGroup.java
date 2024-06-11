public class RevereseKGroup {
    public int getLength(Node head) {
        Node temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    public Node reverseKGroup(Node head, int k) {
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
    
        if(nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }
    
        return prev;
    }
}