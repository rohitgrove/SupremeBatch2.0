public class Add2Numbers {
    public static Node addTwoNumbers(Node num1, Node num2) {
        Node ans = new Node(-1);
        Node it = ans;
        int carry = 0;

        while (num1 != null || num2 != null || carry != 0) {
            int val1 = num1 != null ? num1.data : 0;
            int val2 = num2 != null ? num2.data : 0;
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            it.next = new Node(digit);
            it = it.next;
            num1 = num1 != null ? num1.next : null;
            num2 = num2 != null ? num2.next : null;
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
