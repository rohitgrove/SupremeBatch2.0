import java.util.Stack;

public class PalindromeMethod2 {
    public static Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean checkPalindromeM2(Node head) {
        if (head.next == null || head.next.next == null) {
            if (head.next == null) {
                return true;
            } else if(head.data == head.next.data) {
                return true;
            } else {
                return false;
            }
        }
        
        Node mid = slowFastApproach(head);

        Node head2 = mid.next;
        Node temp = head2;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (!st.isEmpty()) {
            if (st.peek() != temp.data) {
                return false;
            }
            temp = temp.next;
            st.pop();
        }

        return true;
    }

    public static boolean isPalindrome(Node head) {
        return checkPalindromeM2(head);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.printLL();
        System.out.println(isPalindrome(ll.head));

        LinkedList ll2 = new LinkedList();
        ll2.insertAtHead(1);
        ll2.insertAtHead(2);
        ll2.insertAtHead(3);
        ll2.insertAtHead(2);
        ll2.insertAtHead(1);
        ll2.printLL();
        System.out.println(isPalindrome(ll2.head));

        LinkedList ll3 = new LinkedList();
        ll3.insertAtHead(1);
        ll3.insertAtHead(2);
        ll3.insertAtHead(1);
        ll3.insertAtHead(1);
        ll3.printLL();
        System.out.println(isPalindrome(ll3.head));
    }
}
