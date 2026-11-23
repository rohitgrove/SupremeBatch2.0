public class PalindromeLinkedList {
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static Node reverseListUsingLoop(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        Node middleNode = middleNode(head);
        Node secondHead = middleNode.next;
        secondHead = reverseListUsingLoop(secondHead);
        Node temp1 = head;
        Node temp2 = secondHead;
        while (temp1 != null && temp2 != null) {
            if (temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtPosition(2, 2);
        ll.insertAtPosition(2, 3);
        ll.insertAtPosition(1, 4);
        ll.printLL();
        System.out.println(isPalindrome(ll.head));
    }
}
