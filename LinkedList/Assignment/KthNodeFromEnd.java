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

    public static int getNodeRec(Node head, int positionFromTail, int[] currentPosition) {
        if (head == null) {
            return -1;
        }
        int value = getNodeRec(head.next, positionFromTail, currentPosition);
    
        currentPosition[0]++;
        
        if (currentPosition[0] == positionFromTail) {
            return head.data;
        }
        
        return value;
    }

    public static int getNode(Node list, int positionFromTail) {
        int[] currentPosition = new int[1]; 
        currentPosition[0] = -1;
        return getNodeRec(list, positionFromTail, currentPosition); 
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtTail(3);
        ll.insertAtTail(2);
        ll.insertAtTail(1);
        ll.printLL();
        System.out.println(getNode(ll.head, 2));
    }
}
