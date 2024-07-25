import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
        this.next = null;
    }

    public ListNode(int val) {
        this.next = null;
        this.val = val;
    }
}

public class NextGreaterInListNode {
    public static int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> listArr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            listArr.add(temp.val);
            temp = temp.next;
        }

        Stack<Integer> st = new Stack<>();
        int[] res = new int[listArr.size()];
        for (int i = 0; i < listArr.size(); i++) {
            while (!st.empty() && listArr.get(st.peek()) < listArr.get(i)) {
                int kids = st.pop();
                res[kids] = listArr.get(i);
            }

            st.push(i);
        }

        return res;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(3);
        ListNode fifth = new ListNode(5);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        ListNode head = first;

        printArr(nextLargerNodes(head));
    }
}
