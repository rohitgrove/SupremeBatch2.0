import java.util.Stack;

public class PalindromeLL {
    public static Node slowFastApproach(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverseListrec(Node prev, Node curr) {
        // base case
        if (curr == null) {
            return prev;
        }

        Node nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
        return reverseListrec(prev, curr);
    }

    public static boolean compareList(Node head, Node head2) {
        while (head != null && head2 != null) {
            if (head.data != head2.data) {
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    public static boolean checkPalindromeM1(Node head) {
        // break into two halfs
        Node midNode = slowFastApproach(head);
        Node head2 = midNode.next;
        midNode.next = null;

        // reverse second half
        Node prev = null;
        Node curr = head2;
        head2 = reverseListrec(prev, curr);

        // comapre both LinkedList
        boolean ans = compareList(head, head2);
        return ans;
    }

    public static boolean checkPalindromeM2(Node head) {
        Node mid = slowFastApproach(head);

        Node temp = mid.next;
        Stack<Integer> st = new Stack<>();
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (!st.isEmpty() && temp != mid) {
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
    }
}
