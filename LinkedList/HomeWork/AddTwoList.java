public class AddTwoList {
    public static Node addTwoNumbers(Node num1, Node num2) {
        int carry = 0;
        Node ans = new Node(-1);
        Node mtpr = ans;

        Node temp1 = num1;
        Node temp2 = num2;
        while (temp1 != null || temp2 != null || carry != 0) {
            int val1 = 0;
            if (temp1 != null) {
                val1 = temp1.data;
            }

            int val2 = 0;
            if (temp2 != null) {
                val2 = temp2.data;
            }

            int sum = carry + val1 + val2;
            int digit = sum % 10;
            // create node and add in answer linked List
            Node newNode = new Node(digit);
            mtpr.next = newNode;
            mtpr = newNode;

            carry = sum / 10;

            if (temp1 != null) {
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }

        return ans.next;
    }

    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        num1.insertAtPosition(1, 2);
        num1.insertAtPosition(2, 4);
        num1.insertAtPosition(3, 3);

        LinkedList num2 = new LinkedList();
        num2.insertAtPosition(1, 5);
        num2.insertAtPosition(2, 6);
        num2.insertAtPosition(3, 4);
        num2.printLL(addTwoNumbers(num1.head, num2.head));

        LinkedList num3 = new LinkedList();
        num3.insertAtPosition(1, 9);
        num3.insertAtPosition(2, 9);
        num3.insertAtPosition(3, 9);
        num3.insertAtPosition(4, 9);
        num3.insertAtPosition(5, 9);
        num3.insertAtPosition(6, 9);
        num3.insertAtPosition(7, 9);

        LinkedList num4 = new LinkedList();
        num4.insertAtPosition(1, 9);
        num4.insertAtPosition(2, 9);
        num4.insertAtPosition(3, 9);
        num4.printLL(addTwoNumbers(num3.head, num4.head));
    }
}
