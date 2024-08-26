public class MergeTwoSortedList {
    public static Node mergeTwoLists(Node list1, Node list2) {
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
        ll1.insertAtHead(4);
        ll1.insertAtHead(2);
        ll1.insertAtHead(1);
        ll1.printLL();
        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(4);
        ll2.insertAtHead(3);
        ll2.insertAtHead(1);
        ll2.printLL();

        LinkedList ll3 = new LinkedList();
        ll3.head = mergeTwoLists(ll1.head, ll2.head);
        ll3.printLL();
    }
}
