import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreater {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] nextLargerNodes(Node head) {
        List<Integer> ll = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            ll.add(temp.data);
            temp = temp.next;
        }

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[ll.size()];

        for (int i = 0; i < ll.size(); i++) {
            while (!st.isEmpty() && ll.get(i) > ll.get(st.peek())) {
                // means, ith element is the next greater of the element index present in stack
                int kids = st.pop();
                ans[kids] = ll.get(i);
            }
            st.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Node head1 = new Node(2);
        head1.next = new Node(1);
        head1.next.next = new Node(5);
        printArr(nextLargerNodes(head1));

        Node first = new Node(2);
        Node second = new Node(7);
        Node third = new Node(4);
        Node fourth = new Node(3);
        Node fifth = new Node(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        Node head2 = first;
        printArr(nextLargerNodes(head2));
    }
}
