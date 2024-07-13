public class KthNodeFromEnd {
    public static int len(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public static int getNodeItr(Node list, int positionFromTail) {
        int len = len(list);
        int pos = len - positionFromTail - 1;
        Node temp = list;
        while (pos > 0) {
            temp = temp.next;
            pos--;
        }

        return temp.data;
    }

    public static int currentPosition = 0;
    public static int getNodeRec(Node head, int positionFromTail) {
        if (head == null) {
            return -1;
        }
        int value = getNodeRec(head.next, positionFromTail);
    
        currentPosition++;
        
        if (currentPosition == positionFromTail) {
            return head.data;
        }
        
        return value;
    }

    public static int getNode(Node list, int positionFromTail) {
        return getNodeRec(list, positionFromTail); 
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(1);
        ll.insertAtTail(2);
        ll.insertAtTail(3);
        ll.insertAtTail(4);
        ll.printLL();
        System.out.println(getNode(ll.head, 3));
    }
}
