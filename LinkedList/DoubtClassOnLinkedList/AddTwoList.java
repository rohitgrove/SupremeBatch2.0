public class AddTwoList {
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy; 
        int carry = 0; 
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; 
            if(l1 != null){ 
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry; 
            carry = sum/10; 
            Node newNode = new Node(sum % 10); 
            curr.next = newNode; 
            curr = curr.next; 
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtTail(2);
        ll1.insertAtTail(4);
        ll1.insertAtTail(3);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtTail(5);
        ll2.insertAtTail(6);
        ll2.insertAtTail(4);
        ll2.printLL();

        LinkedList ll3 = new LinkedList();
        ll3.head = addTwoNumbers(ll1.head, ll2.head);
        ll3.printLL();
    }
}
