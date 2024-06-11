public class AddOneToALL {
    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
    public Node addOne(Node head) {
        // reverse
        head = reverse(head);

        // add1
        int carry = 1;
        Node temp = head;
        while (temp.next != null) {
            int totalSum = temp.data + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;

            temp.data = digit;
            temp = temp.next;
            if (carry == 0) {
                break;
            }
        }

        // process last node
        if (carry != 0) {
            int totalSum = temp.data + carry;
            int digit = totalSum % 10;
            carry = totalSum / 10;
            
            temp.data = digit;
            if (carry != 0) {
                temp.next = new Node(carry);
            }
        }

        // reverse
        head = reverse(head);
        return head;        
    }        
}
