public class MergeSort {
    public static Node midNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = midNode(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = sortList(head);
        right = sortList(right);
        return mergeLists(left, right);
    }

    public static Node mergeLists(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }        
        if (list2 == null) {
            return list1;
        }

        Node head = new Node(-1);
        Node temp = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }

        head = head.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertAtHead(3); 
        ll1.insertAtHead(1); 
        ll1.insertAtHead(2); 
        ll1.insertAtHead(4);
        ll1.printLL(); 
        ll1.head = sortList(ll1.head);
        ll1.printLL();

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(0);
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(5);
        ll2.insertAtHead(-1);
        ll2.printLL();
        ll2.head = sortList(ll2.head);
        ll2.printLL();
    }
}
