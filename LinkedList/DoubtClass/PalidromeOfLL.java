import java.util.Stack;

public class PalidromeOfLL {
    public static Node midNode(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean isPalindrome(Node head) {
        Stack<Node> st = new Stack<>();
        Node getMidNode = midNode(head);
        Node temp = getMidNode.next;
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }

        temp = head;
        while (!st.isEmpty()) {
            if (temp.data != st.peek().data) {
                return false;
            }
            temp = temp.next;
            st.pop();
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList oddLL = new LinkedList();
        oddLL.insertAtPosition(1, 1);
        oddLL.insertAtPosition(2, 2);
        oddLL.insertAtPosition(3, 3);
        oddLL.insertAtPosition(4, 2);
        oddLL.insertAtPosition(5, 1);
        oddLL.printLL();
        System.out.println(isPalindrome(oddLL.head));

        LinkedList evenLL = new LinkedList();
        evenLL.insertAtPosition(1, 1);
        evenLL.insertAtPosition(2, 2);
        evenLL.insertAtPosition(3, 3);
        evenLL.insertAtPosition(4, 4);
        evenLL.insertAtPosition(5, 2);
        evenLL.insertAtPosition(6, 1);
        evenLL.printLL();
        System.out.println(isPalindrome(evenLL.head));

        LinkedList LL = new LinkedList();
        LL.insertAtPosition(1, 2);
        LL.insertAtPosition(2, 4);
        LL.insertAtPosition(3, 6);
        LL.insertAtPosition(4, 8);
        LL.insertAtPosition(5, 10);
        LL.printLL();
        System.out.println(isPalindrome(LL.head));
    }
}
